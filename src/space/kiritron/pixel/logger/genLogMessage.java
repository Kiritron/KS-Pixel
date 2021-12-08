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

package space.kiritron.pixel.logger;

import space.kiritron.pixel.GDate;
import space.kiritron.pixel.console.consoleColors;

/**
 * @author Киритрон Стэйблкор
 */

public class genLogMessage {
    /**
     * Генерация сообщения для последующего вывода в консоль или лог-файл.
     * @param type Тип сообщения. 0(или любое другое свободное число, но рекомендуется 0) - без типа, 1 - Информация, 2 - Предупреждение, 3 - Ошибка. Если без типа,
     *             то type_style и type_color перестают на что-либо влиять и вы можете установить их как 0, хотя необязательно и является
     *             лишь рекомендацией.
     * @param type_style Стиль типа. 1(или любое другое свободное число) - стандарт(Прим. "ИНФО"), 2 - сокращённый(Прим. "И"), 3 - символический(Прим. "i").
     * @param type_color true - к типу сообщения добавляется цветовой код, false - к типу сообщения цветовой код добавлен не будет
     * @param timeWithDate true, если нужно сгенерировать сообщение не только, со временем, но и с датой. false - если нужно только время.
     * @param message Сгенерированное сообщение для последующего вывода в консоль или лог-файл.
     * @return Возвращает сгенерированное сообщение.
     */
    public static String gen(int type, int type_style, boolean type_color, boolean timeWithDate, String message) {
        String TimeString;
        String TYPE = null; // (:<)

        if (timeWithDate) {
            TimeString = GDate.GetTimeWithSeconds();
        } else {
            TimeString = GDate.GetCurDateAndTimeWithSeconds();
        }

        if (type != 0) {
            if (type == 1) {
                if (type_style != 2 && type_style != 3) {
                    TYPE = "ИНФО";
                }

                if (type_style == 2) {
                    TYPE = "И";
                }

                if (type_style == 3) {
                    TYPE = "i";
                }
            }

            if (type == 2) {
                if (type_style != 2 && type_style != 3) {
                    TYPE = "ПРЕДУПРЕЖДЕНИЕ";
                }

                if (type_style == 2) {
                    TYPE = "П";
                }

                if (type_style == 3) {
                    TYPE = "!";
                }
            }

            if (type == 3) {
                if (type_style != 2 && type_style != 3) {
                    TYPE = "ОШИБКА";
                }

                if (type_style == 2) {
                    TYPE = "О";
                }

                if (type_style == 3) {
                    TYPE = "x";
                }
            }

            if (type_color) {
                if (TYPE != null) {
                    if (type == 2) {
                        TYPE = consoleColors.YELLOW + TYPE + consoleColors.RESET;
                    }

                    if (type == 3) {
                        TYPE = consoleColors.RED + TYPE + consoleColors.RESET;
                    }
                }
            }
        }

        if (TYPE != null) {
            if (type_style != 2 && type_style != 3) {
                return "[" + TimeString + " " + TYPE + "]: " + message;
            } else {
                return "[" + TimeString + "]" + "[" + TYPE + "]: " + message;
            }
        } else {
            return "[" + TimeString + "]: " + message;
        }
    }

}
