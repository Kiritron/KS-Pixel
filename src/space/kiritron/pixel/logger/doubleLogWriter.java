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

/**
 * @author Киритрон Стэйблкор
 */

package space.kiritron.pixel.logger;

import static space.kiritron.pixel.logger.toFile.WriteLogWithPrefix;
import static space.kiritron.pixel.logger.toFile.WriteLogNoPrefix;

/**
 * @author Киритрон Стэйблкор
 */

public class doubleLogWriter {
    /**
     * Вывод и в консоль, и в лог файл без префикса в названии. Цветовые коды добавляются только при выводе в консоль, а лог-файле цветовых кодов не будет.
     * @param type Тип сообщения. 0(или любое другое свободное число, но рекомендуется 0) - без типа, 1 - Информация, 2 - Предупреждение, 3 - Ошибка. Если без типа,
     *             то type_style и type_color перестают на что-либо влиять и вы можете установить их как 0, хотя необязательно и является
     *             лишь рекомендацией.
     * @param type_style Стиль типа. 1(или любое другое свободное число) - стандарт(Прим. "ИНФО"), 2 - сокращённый(Прим. "И"), 3 - символический(Прим. "i").
     * @param type_color true - к типу сообщения добавляется цветовой код, false - к типу сообщения цветовой код добавлен не будет
     * @param message Сообщение, которое нужно вывести в консоль.
     */
    public static void write(int type, int type_style, boolean type_color, String message) {
        String log_message;
        log_message = genLogMessage.gen(type, type_style, type_color, false, message);
        toConsole.print(log_message);
        log_message = genLogMessage.gen(type, type_style, false, false, message);
        WriteLogNoPrefix(log_message);
    }

    /**
     * Вывод и в консоль, и в лог файл с префиксом в названии. Цветовые коды добавляются только при выводе в консоль, а лог-файле цветовых кодов не будет.
     * @param type Тип сообщения. 0(или любое другое свободное число, но рекомендуется 0) - без типа, 1 - Информация, 2 - Предупреждение, 3 - Ошибка. Если без типа,
     *             то type_style и type_color перестают на что-либо влиять и вы можете установить их как 0, хотя необязательно и является
     *             лишь рекомендацией.
     * @param type_style Стиль типа. 1(или любое другое свободное число) - стандарт(Прим. "ИНФО"), 2 - сокращённый(Прим. "И"), 3 - символический(Прим. "i").
     * @param type_color true - к типу сообщения добавляется цветовой код, false - к типу сообщения цветовой код добавлен не будет
     * @param prefix Префикс лог-файла.
     * @param message Сообщение, которое нужно вывести в консоль.
     */
    public static void writeWithPrefix(int type, int type_style, boolean type_color, String prefix, String message) {
        String log_message;
        log_message = genLogMessage.gen(type, type_style, type_color, false, message);
        toConsole.print(log_message);
        log_message = genLogMessage.gen(type, type_style, false, false, message);
        WriteLogWithPrefix(prefix, log_message);
    }
}
