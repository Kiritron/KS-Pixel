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

import java.util.Random;

/**
 * @author Киритрон Стэйблкор
 */

// Киритрон: Хотел сначала назвать класс просто Math, но вспомнил, что аналогичный класс имеется в самом Java.
// Чтобы не создавать путаницу, я решил назвать класс PixelMath.
public class PixelMath {
    /**
     * Генерация случайного числа в заданном диапазоне
     * @param min Минимальное значение диапазона
     * @param max Максимальное значение диапазона
     * @return возвращает случайное число в заданном диапазоне
     */
    /* "Случайности не случайны." - мастер Угвей. (мульт. Кунг-фу панда) */
    public static int genRandom(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    /**
     * Получение числа, которое ограничено диапазоном.
     * @param value Число
     * @param min Минимальное значение диапазона
     * @param max Максимальное значение диапазона
     * @return Возвращает float число, ограниченное диапазоном от min до max включительно.
     */
    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    /**
     * Округление числа.
     * @param value Число, которое нужно округлить
     * @param index До какого знака округлить. Например, чтобы из X.XXXXX получить X.XXX, введите 3.
     * @return возвращает округлённое число.
     */
    public static double round(double value, int index) {
         return Double.parseDouble(String.format("%." + index + "f",value));
    }
}
