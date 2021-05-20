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

package space.kiritron.pixel.filefunc;

import java.io.File;
import java.io.IOException;

/**
 * @author Киритрон Стэйблкор
 */

public class DirControls {
    /**
     * Поиск каталога.
     * @param dirname Путь до каталога.
     * @return возвращает результат поиска. TRUE - каталог есть, FALSE - каталога нет.
     */
    public static boolean checkDirExists(String dirname) {
        return new File(dirname).exists(); // Да, ничем не отличается от аналога с файлами, но так всё равно удобнее
    }

    /**
     * Создать каталог.
     * @param dirname Путь до каталога.
     */
    public static void CreateDir(String dirname) throws IOException {
        File TargetDir = new File(dirname);

        if (checkDirExists(dirname) && new File(dirname).isDirectory()) {
            throw new IOException("Каталог \"" + TargetDir.getName() + "\" уже существует.");
        }

        if (!new File(dirname).mkdir()) {
            throw new IOException("Каталог \"" + TargetDir.getName() + "\" создать не удалось.");
        }
    }

    /**
     * Удаление каталога.
     * @param dirname Путь до каталога.
     */
    public static void DeleteDir(String dirname) throws IOException {
        File TargetDir = new File(dirname);

        if (!TargetDir.delete()) {
            throw new IOException("Каталог \"" + TargetDir.getName() + "\" удалить не получилось.");
        }
    }

    /**
     * Принудительное удаление. Удаляет каталог со всем, что есть внутри.
     * @param dirname Путь до каталога.
     */
    public static void ForceDeleteDir(String dirname) throws IOException {
        File TargetDir = new File(dirname);
        File[] files = TargetDir.listFiles();

        // Сканируем всё, что внутри каталога и удаляем
        if (files!=null) {
            for (File f: files) {
                if (f.isDirectory()) {
                    try {
                        ForceDeleteDir(String.valueOf(f));
                    } catch (IOException e) {
                        throw new IOException(e);
                    }
                } else {
                    if (!f.delete()) {
                        throw new IOException("Не удалось удалить файл \"" + f.getName() + "\" при принудительном удалении каталога.");
                    }
                }
            }
        }

        // ...затем удаляем сам каталог.
        if (!TargetDir.delete()) {
            throw new IOException("Каталог \"" + TargetDir.getName() + "\" не получилось принудительно удалить.");
        }
    }
}
