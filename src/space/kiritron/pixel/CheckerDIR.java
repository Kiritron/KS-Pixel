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

package space.kiritron.pixel;

import space.kiritron.pixel.filefunc.GetPathOfAPP;

import java.io.IOException;

import static space.kiritron.pixel.filefunc.DirControls.CreateDir;
import static space.kiritron.pixel.filefunc.DirControls.checkDirExists;

/**
 * @author Киритрон Стэйблкор
 */

public class CheckerDIR {
    // Данный содержит методы, которые были созданы для классов инициализации в приложениях на ЯП Java.
    // Эти методы всего одной строкой быстро и элегантно позволяют инициализировать каталоги, которые
    // необходимы для работы приложения.

    /**
     * Поиск каталога в директории, где запущено данное ПО. Если каталога нет, то он будет создан.
     * @param dir Путь до каталога относительно корневого каталога, где запущено данное приложение.
     */
    public static void Check(String dir) {
        if (!checkDirExists(GetPathOfAPP.GetPathWithSep() + dir)) {
            try {
                CreateDir(GetPathOfAPP.GetPathWithSep() + dir);
            } catch (IOException e) {
                // Ничего. Данный метод не предусматривает какой либо вывод.
            }
        }
    }

    /**
     * Поиск каталога вне директории, где запущено данное ПО. Если каталога нет, то он будет создан.
     * @param path Путь до каталога.
     */
    public static void CheckOut(String path) {
        if (!checkDirExists(path)) {
            try {
                CreateDir(path);
            } catch (IOException e) {
                // Ничего. Данный метод не предусматривает какой либо вывод.
            }
        }
    }
}
