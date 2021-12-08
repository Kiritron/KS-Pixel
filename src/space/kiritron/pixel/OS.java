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

import java.io.File;
import java.lang.management.ManagementFactory;

/**
 * @author Киритрон Стэйблкор
 */

public class OS {
    /**
     * Узнать имя ОС, на которой запущено данное ПО.
     * @return возвращает имя операционной системы.
     */
    public static String getName() {
        return System.getProperty("os.name");
    }

    /**
     * Узнать архитектуру ОС, на которой запущено данное ПО.
     * @return возвращает архитектуру операционной системы.
     */
    public static String getArch() {
        return System.getProperty("os.arch");
    }

    /**
     * Узнать версию ОС, на которой запущено данное ПО.
     * @return возвращает версию операционной системы.
     */
    public static String getVersion() {
        return System.getProperty("os.version");
    }

    /**
     * Узнать имя пользователя
     * @return возвращает имя пользователя.
     */
    public static String getUserName() {
        return System.getProperty("user.name");
    }

    /**
     * Узнать домашний каталог пользователя.
     * @return возвращает домашний каталог пользователя.
     */
    public static String getUserHome() {
        return System.getProperty("user.home");
    }

    /**
     * Узнать, в какой стране находится пользователь(исходя из настроек). Примеры ответа: RU, US.
     * @return возвращает код страны, в которой находится пользователь(исходя из настроек).
     */
    public static String getCountry() {
        return System.getProperty("user.country");
    }

    /**
     * Узнать, какой язык установлен в системе. Примеры ответа: ru, en.
     * @return возвращает код языка, который установлен в системе.
     */
    public static String getLanguage() {
        return System.getProperty("user.language");
    }

    /**
     * Узнать на Windows ли сейчас работает данная программа.
     * @return возвращает boolean значение.
     */
    public static boolean isWindows() {
        return getName().toLowerCase().contains("windows");
    }

    /**
     * Узнать на OS X ли сейчас работает данная программа.
     * @return возвращает boolean значение.
     */
    public static boolean isMacintosh() {
        return getName().toLowerCase().contains("mac");
    }

    /**
     * Узнать на системе с ядром Linux сейчас работает данная программа или нет.
     * @return возвращает boolean значение.
     */
    public static boolean isLinux() {
        return getName().toLowerCase().contains("linux");
    }

    /**
     * Узнать максимальный объём оперативной памяти в системе(именно в системе). Обратите внимание, что в единицах измерения выше байта данный метод округляет ответ.
     * @param type Единица измерения. 0 - байты, 1 - килобайты, 2 - мегабайты, 3 - гигабайты, любое другое число - байты :D
     * @return возвращает строку с объёмом оперативной памяти в выбранной системе счисления.
     */
    public static String getMaxMemory(int type) {
        long memorySize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();

        switch (type) {
            case (1):
                return String.format("%.0f", (double) (memorySize / 1024));
            case (2):
                return String.format("%.0f", (double) memorySize / 1024 / 1024);
            case (3):
                return String.format("%.0f", (double) memorySize / 1024 / 1024 / 1024);
            default:
                return String.valueOf(memorySize);
        }
    }

    /**
     * Узнать объём системного диска. Обратите внимание, что в единицах измерения выше байта данный метод округляет ответ.
     * @param typeSpace Какое пространство нужно посчитать. 0 - всё пространство диска, 1 - свободное пространство диска, 2 - занятое пространство диска,
     *                  любое другое число - всё пространство диска
     * @param typeValue Единица измерения. 0 - байты, 1 - килобайты, 2 - мегабайты, 3 - гигабайты, любое другое число - байты
     * @return возвращает строку с объёмом оперативной памяти в выбранной системе счисления.
     */
    public static String getVolumeOfSystemDiskDrive(int typeSpace, int typeValue) throws Exception {
        File DiskDrive;
        long space;

        if (isWindows()) {
            DiskDrive = new File("C:");
        } else if (isLinux() || isMacintosh()) {
            DiskDrive = new File("/");
        } else {
            throw new Exception("ОС не поддерживается");
        }

        switch (typeSpace) {
            case (1):
                space = DiskDrive.getTotalSpace();
                break;
            case (2):
                space = DiskDrive.getFreeSpace();
                break;
            case (3):
                space = DiskDrive.getUsableSpace();
                break;
            default:
                space = DiskDrive.getTotalSpace();
                break;
        }

        switch (typeValue) {
            case (1):
                return String.format("%.0f", space / 1024);
            case (2):
                return String.format("%.0f", space / 1024 / 1024);
            case (3):
                return String.format("%.0f", space / 1024 / 1024 / 1024);
            default:
                return String.valueOf(space);
        }
    }
}
