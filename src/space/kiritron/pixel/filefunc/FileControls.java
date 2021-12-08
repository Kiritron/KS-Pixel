/*
 * Copyright 2022 Kiritron's Space
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

package space.kiritron.pixel.filefunc;

import java.io.*;

/**
 * @author Киритрон Стэйблкор
 */

public class FileControls {
    /**
     * Поиск файла.
     * @param filename Путь до файла.
     * @return возвращает результат поиска. TRUE - файл есть, FALSE - файла нет.
     */
    public static boolean checkFileExists(String filename) {
        return new File(filename).exists();
    }

    /**
     * Узнать файл ли это.
     * @param filename Путь до файла.
     * @return возвращает результат проверки. TRUE - это файл, FALSE - это каталог или что-то иное(что?).
     */
    public static boolean isFile(String filename) {
        return new File(filename).isFile();
    }

    /**
     * Удаление файла.
     * @param filename Путь до файла.
     */
    public static void DeleteFile(String filename) throws IOException {
        if (!new File(filename).delete()) {
            throw new IOException("Файл удалить не получилось.");
        }
    }

    /**
     * Создание файла.
     * @param filename Путь до файла.
     */
    public static void CreateFile(String filename) throws IOException {
        File TargetFile = new File(filename);

        if (checkFileExists(filename) && new File(filename).isFile()) {
            throw new IOException("Файл \"" + TargetFile.getName() + "\" уже существует.");
        }

        if (!new File(filename).createNewFile()) {
            throw new IOException("Файл \"" + TargetFile.getName() + "\" создать не получилось.");
        }
    }

    /**
     * Прочитать файл.
     * @param filename Путь до файла.
     * @return возвращает данные, которые удалось вытянуть из файла.
     * @throws IOException Сбой при обработке файла. Например, может быть, если файл не будет найден.
     */
    public static String ReadFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader (filename));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );
            stringBuilder.append( ls );
        }

        if (stringBuilder.length() != 0) {
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

        return stringBuilder.toString();
    }

    /**
     * Записать в файл. Если файла нет, то он будет создан. Обратите внимание, данный метод перезаписывает данные, а не дополняет их.
     * @param filename Путь до файла.
     * @param data Данные, которые нужно записать в файл.
     */
    public static void writeToFile(String filename, String data) throws IOException {
        File TargetFile = new File(filename);

        if (!(checkFileExists(filename) && TargetFile.isFile())) {
            CreateFile(filename);
        }

        try (FileWriter fr = new FileWriter(TargetFile)) {
            fr.write(data);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    /**
     * Записать байт-массив в файл. Если файла нет, то он будет создан. Обратите внимание, данный метод перезаписывает данные, а не дополняет их.
     * @param filename Путь до файла.
     * @param byte_array Байт-массив, который нужно записать в файл.
     */
    public static void ByteArrayToFile(String filename, byte[] byte_array) throws IOException {
        if (!(checkFileExists(filename) && new File(filename).isFile())) {
            CreateFile(filename);
        }

        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(byte_array);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    /**
     * Добавить данные в файл. Работает как и writeToFile, но дополняет данные, а не перезаписывает.
     * @param filename Путь до файла.
     * @param data Данные, которые нужно записать в файл.
     */
    public static void addDataToFile(String filename, String data) throws IOException {
        String CACHE;

        try {
            CACHE = ReadFile(filename) + data;
        } catch (IOException ee) {
            throw new IOException(ee);
        }

        try (FileWriter fr = new FileWriter(new File(filename))) {
            fr.write(CACHE);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    /**
     * Переместить файл в другую папку.
     * @param filename Путь до файла.
     * @param destpath Директория, в которую необходимо перенести файл.
     */
    public static void movingFile(String filename, String destpath) throws IOException {
        File TargetFile = new File(filename);

        if (checkFileExists(filename)) {
            if (!destpath.substring(destpath.length() - 1).contains(GetPathOfAPP.GetSep())) {
                destpath = destpath + GetPathOfAPP.GetSep();
            }

            File destFolder = new File(destpath + TargetFile.getName());

            if (!TargetFile.renameTo(destFolder)) {
                throw new IOException("Перенести файл \"" + TargetFile.getName() + "\" не удалось.");
            }
        } else {
            throw new IOException("Файл \"" + TargetFile.getName() + "\" не найден.");
        }
    }

    /**
     * Переименовать файл.
     * @param filename Путь до файла.
     * @param newfilename Новое имя файла.
     */
    public static void renameFile(String filename, String newfilename) throws IOException {
        File TargetFile = new File(filename);

        if (checkFileExists(filename)) {
            File destFolder = new File(filename.replace(TargetFile.getName(), "") + newfilename);

            if (!TargetFile.renameTo(destFolder)) {
                throw new IOException("Переименовать файл \"" + TargetFile.getName() + "\" не удалось.");
            }
        } else {
            throw new IOException("Файл \"" + TargetFile.getName() + "\" не найден.");
        }
    }

    /**
     * Скопировать файл.
     * @param in_filename Путь до файла, который необходимо скопировать.
     * @param out_dir Путь, в который файл необходимо скопировать.
     */
    public static void copyFile(String in_filename, String out_dir) throws IOException {
        File in_f = new File(in_filename);

        if (checkFileExists(in_filename)) {
            if (!checkFileExists(out_dir + in_f.getName())) {
                if (!out_dir.substring(out_dir.length() - 1).contains(GetPathOfAPP.GetSep())) {
                    out_dir = out_dir + GetPathOfAPP.GetSep();
                }

                File out_f = new File(out_dir + in_f.getName());

                InputStream is = null;
                OutputStream os = null;

                try {
                    is = new FileInputStream(in_f);
                    os = new FileOutputStream(out_f);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = is.read(buffer)) > 0) {
                        os.write(buffer, 0, length);
                    }
                } catch (IOException EeE) {
                    throw new IOException(EeE);
                } finally {
                    try {
                        assert is != null;
                        is.close();
                        assert os != null;
                        os.close();
                    } catch (IOException e) {
                        throw new IOException(e);
                    }
                }
            } else {
                throw new IOException("В директории, куда надо скопировать файл \"" + in_f.getName() + "\", уже есть файл с таким названием.");
            }
        } else {
            throw new IOException("Файл \"" + in_f.getName() + "\" не найден.");
        }
    }
}
