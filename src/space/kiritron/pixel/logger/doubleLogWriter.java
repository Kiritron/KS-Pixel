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

import static space.kiritron.pixel.logger.toFile.WriteLogNoPrefix;

public class doubleLogWriter {
    /**
     * Вывод и в консоль, и в лог файл. Сообщения будут без указания даты, но к дате будут привязаны логфайлы.
     * @param code Тип сообщения. 0 - без типа, 1 - Информация, 2 - Предупреждение, 3 - Ошибка.
     * @param message Сообщение, которое нужно вывести в консоль.
     * @return ничего. Метод просто исполняется.
     */
    public static void write(int code, String message) {
        String log_message;
        log_message = genLogMessage.gen(code, false, true, message);
        toConsole.print(log_message);
        log_message = genLogMessage.gen(code, false, false, message);
        WriteLogNoPrefix(log_message);
    }
}
