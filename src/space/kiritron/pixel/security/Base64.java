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

package space.kiritron.pixel.security;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author Киритрон Стэйблкор
 */

/* ¯\_(ツ)_/¯ */
public class Base64 {
    /**
     * Base64 кодирование текста.
     * @param message Сообщение, которое нужно кодировать в Base64.
     * @return закодированный в Base64 текст.
     */
    public static String encrypt(String message) {
        return java.util.Base64.getEncoder().encodeToString(message.getBytes(UTF_8));
    }

    /**
     * Base64 декодирование текста.
     * @param message Сообщение, которое нужно декодировать от алгоритма Base64.
     * @return декодированный от Base64 текст.
     */
    public static String decrypt(String message) throws IllegalArgumentException {
        return new String(java.util.Base64.getDecoder().decode(message));
    }
}
