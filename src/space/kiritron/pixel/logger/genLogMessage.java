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

package space.kiritron.pixel.logger;

import space.kiritron.pixel.GDate;
import space.kiritron.pixel.filefunc.GetPathOfAPP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Киритрон Стэйблкор
 */

public class genLogMessage {
    private static GDate TADClass = new GDate();

    private final static String INFO = "ИНФО";
    private final static String WARN = consoleColors.YELLOW + "ПРЕДУПРЕЖДЕНИЕ" + consoleColors.RESET;
    private final static String ERROR = consoleColors.RED + "ОШИБКА" + consoleColors.RESET;
    private final static String WARN_NOCOLOR = "ПРЕДУПРЕЖДЕНИЕ";
    private final static String ERROR_NOCOLOR = "ОШИБКА";

    /**
     * Генерация вывода сообщения в консоль.
     * @param type Тип сообщения. 0 - без типа, 1 - Информация, 2 - Предупреждение, 3 - Ошибка.
     * @param timeWithDate true - если нужно сгенерировать сообщение не только, со временем, но и с датой. false - если нужно только время.
     * @param color true - к типу сообщения добавляется цветовой код, false - к типу сообщения цветовой код добавлен не будет
     * @param message Сообщение, которое нужно вывести в консоль.
     * @return Возвращает сгенерированное сообщение.
     */
    public static String gen(int type, boolean timeWithDate, boolean color, String message) {
        if (type == 1) {
            if (timeWithDate == false) {
                return "[" + TADClass.GetTimeWithSeconds + " " + INFO + "]: " + message;
            } else {
                return "[" + TADClass.GetCurDateAndTimeWithSeconds + " " + INFO + "]: " + message;
            }
        } else if (type == 2) {
            if (timeWithDate == false) {
                if (color) {
                    return "[" + TADClass.GetTimeWithSeconds + " " + WARN + "]: " + message;
                } else {
                    return "[" + TADClass.GetTimeWithSeconds + " " + WARN_NOCOLOR + "]: " + message;
                }
            } else {
                if (color) {
                    return "[" + TADClass.GetCurDateAndTimeWithSeconds + " " + WARN + "]: " + message;
                } else {
                    return "[" + TADClass.GetCurDateAndTimeWithSeconds + " " + WARN_NOCOLOR + "]: " + message;
                }
            }
        } else if (type == 3) {
            if (timeWithDate == false) {
                if (color) {
                    return "[" + TADClass.GetTimeWithSeconds + " " + ERROR + "]: " + message;
                } else {
                    return "[" + TADClass.GetTimeWithSeconds + " " + ERROR_NOCOLOR + "]: " + message;
                }
            } else {
                if (color) {
                    return "[" + TADClass.GetCurDateAndTimeWithSeconds + " " + ERROR + "]: " + message;
                } else {
                    return "[" + TADClass.GetCurDateAndTimeWithSeconds + " " + ERROR_NOCOLOR + "]: " + message;
                }
            }
        } else {
            if (timeWithDate == false) {
                return "[" + TADClass.GetTimeWithSeconds + "]: " + message;
            } else {
                return "[" + TADClass.GetCurDateAndTimeWithSeconds + "]: " + message;
            }
        }
    }

}
