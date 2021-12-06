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

import space.kiritron.pixel.OS;

import java.io.File;

/**
 * @author Киритрон Стэйблкор
 */

public class GetPathOfAPP {
    /**
     * Получить адрес папки, в которой запущено данное ПО.
     * @return возвращает адрес папки.
     */

    public static String GetPath() {
        String path = System.getProperty("user.dir");
        return path;
    }

    /**
     * Получить адрес папки, в которой запущено данное ПО, но со слешем на конце.
     * @return возвращает адрес папки.
     */
    public static String GetPathWithSep() {
        String fpath = System.getProperty("user.dir");
        String spath = GetSep();
        String tpath = fpath + spath;

        return tpath;
    }

    /**
     * Получить слеш, который характерен для ОС, на которой запущено данное ПО.
     * @return возвращает слеш.
     */
    public static String GetSep() {
        return File.separator;
    }
}
