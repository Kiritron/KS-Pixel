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

package space.kiritron.pixel;

import space.kiritron.pixel.filefunc.FileControls;

import java.io.IOException;

/**
 * @author Киритрон Стэйблкор и MR.REX
 */

//Киритрон: Вношу изменения уже второй раз, так как немного обосрался с контролем версий и потерял
//новую версию данного класса.
public class GetOS {
    public static String Name = "os.name",
                         Arch = "os.arch",
                         Version = "os.version",
                         User = "user.name",
                         UserDir = "user.dir",
                         UserHome = "user.home";

    /**
     * Узнать имя ОС, на которой запущено данное ПО.
     * @return возвращает имя операционной системы.
     */
    public static String Get() {
        return System.getProperty("os.name");
    }

    /**
     * Узнать на Windows ли сейчас работает данная программа.
     * @return возвращает boolean значение.
     */
    public static boolean isWindows() {
        return Get().toLowerCase().contains("windows");
    }

    /**
     * Узнать на OS X ли сейчас работает данная программа.
     * @return возвращает boolean значение.
     */
    public static boolean isMacintosh() {
        return Get().toLowerCase().contains("mac");
    }

    /**
     * Узнать на системе с ядром Linux сейчас работает данная программа или нет.
     * @return возвращает boolean значение.
     */
    public static boolean isLinux() {
        return Get().toLowerCase().contains("linux");
    }

    /**
     * Позволяет получить данные об ОС, на которой запущено данное ПО.
     * @param Type Какую информацию необходимо получить об ОС. Доступны Name, Arch, Version, User, UserDir, UserHome.
     * @return возвращает ту информацию об ОС, которую вы запросили.
     */
    public static String GetOther(String Type) {
        return System.getProperty(Type);
    }
}
