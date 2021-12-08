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

/**
 * @author Киритрон Стэйблкор
 */

// Класс c операциями с переменными
public class VarFunc {
    /**
     * Метод для проверки строки на присутствие числа в строке, которое можно загнать под Integer.
     * @param string Строка, которую нужно проверить.
     * @return Возвращает TRUE, если строка содержит число, которое можно взять. Возвращает FALSE, если строка не содержит число или в строке каша, из-за которой число излвечь не получится.
     */
    public static boolean isInt(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
