/*
 * Copyright 2021 Kiritron's Space
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package space.kiritron.pixel.compressors;

import space.kiritron.pixel.filefunc.DirControls;
import space.kiritron.pixel.filefunc.FileControls;
import space.kiritron.pixel.filefunc.GetPathOfAPP;
import space.kiritron.pixel.logger.toConsole;

import java.io.*;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author Киритрон Стэйблкор & Mkyong
 */

public class Zip {
    /**
     * Архивировать файл в ZIP архив.
     * @param source Адрес файла.
     * @param nameZipFile Адрес архива. Обратите внимание, что данный метод может заменить уже существующий архив.
     */
    public static void zipFile(String source, String nameZipFile) throws Exception {
        zipping(source, nameZipFile);
    }

    /**
     * Архивировать директорию в ZIP архив.
     * @param source Адрес директории.
     * @param nameZipFile Адрес архива. Обратите внимание, что данный метод может заменить уже существующий архив.
     */
    public static void zipDir(String source, String nameZipFile) throws Exception {
        zipping(source, nameZipFile);
    }

    /**
     * Архивировать несколько элементов(файлы и папки) в ZIP архив.
     * @param sources Массив адресов файлов и папок.
     * @param nameZipFile Адрес архива. Обратите внимание, что данный метод может заменить уже существующий архив.
     */
    public static void zipMultipleElements(String[] sources, String nameZipFile) throws Exception {
        zipping(sources, nameZipFile);
    }

    /**
     * Распаковать ZIP архив.
     * @param zipFileName Адрес архива.
     * @param dirName Адрес директории, в которую будет распаковано содержимое архива.
     */
    public static void unzipFile(String zipFileName, String dirName) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFileName))) {
            ZipEntry zipEntry = zis.getNextEntry();

            while (zipEntry != null) {
                boolean isDirectory = false;
                if (zipEntry.getName().endsWith(GetPathOfAPP.GetSep())) {
                    isDirectory = true;
                }

                Path newPath = zipSlipProtect(zipEntry, Paths.get(dirName));

                if (isDirectory) {
                    Files.createDirectories(newPath);
                } else {
                    if (newPath.getParent() != null) {
                        if (Files.notExists(newPath.getParent())) {
                            Files.createDirectories(newPath.getParent());
                        }
                    }

                    try (FileOutputStream fos = new FileOutputStream(newPath.toFile())) {
                        byte[] buffer = new byte[4096];
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }

                zipEntry = zis.getNextEntry();
            }

            zis.closeEntry();
        }
    }

    private static void zipping(String source, String nameZipFile) throws Exception {
        FileOutputStream fos = new FileOutputStream(nameZipFile);
        ZipOutputStream zos = new ZipOutputStream(fos);

        if (FileControls.isFile(source) && !DirControls.isDir(source)) {
            FileInputStream fis = new FileInputStream(source);

            zos.putNextEntry(new ZipEntry(source));

            byte[] buffer = new byte[4096];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            fis.close();
        } else if (!FileControls.isFile(source) && DirControls.isDir(source)) {
            scanDirectory(zos, new File(source));
        } else {
            throw new IOException("Это не файл и не каталог. Непонятно, что с этим делать.");
        }

        zos.closeEntry();
        zos.close();
    }

    private static void zipping(String[] sources, String nameZipFile) throws Exception {
        FileOutputStream fos = new FileOutputStream(nameZipFile);
        ZipOutputStream zos = new ZipOutputStream(fos);

        for (int i = 0; i < sources.length;) {
            if (FileControls.isFile(sources[i]) && !DirControls.isDir(sources[i])) {
                FileInputStream fis = new FileInputStream(sources[i]);

                zos.putNextEntry(new ZipEntry(sources[i]));

                byte[] buffer = new byte[4096];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }

                fis.close();
            } else if (!FileControls.isFile(sources[i]) && DirControls.isDir(sources[i])) {
                scanDirectory(zos, new File(sources[i]));
            } else {
                toConsole.print_error("Это не файл и не каталог. Непонятно, что с этим делать.");
                // throw new IOException("Это не файл и не каталог. Непонятно, что с этим делать.");
            }

            i++;
        }

        zos.closeEntry();
        zos.close();
    }

    private static Path zipSlipProtect(ZipEntry zipEntry, Path targetDir) throws IOException {
        Path targetDirResolved = targetDir.resolve(zipEntry.getName());

        Path normalizePath = targetDirResolved.normalize();
        if (!normalizePath.startsWith(targetDir)) {
            throw new IOException("Плохая запись в ZIP - " + zipEntry.getName());
        }

        return normalizePath;
    }

    private static void scanDirectory(ZipOutputStream zos, File fileSource) throws Exception {
        File[] files = fileSource.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                scanDirectory(zos, files[i]);
                continue;
            }

            FileInputStream fis = new FileInputStream(files[i]);

            zos.putNextEntry(new ZipEntry(files[i].getPath()));

            byte[] buffer = new byte[4096];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            fis.close();
        }
    }
}
