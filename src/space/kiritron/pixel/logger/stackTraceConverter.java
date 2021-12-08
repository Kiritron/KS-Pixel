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

/**
 * @author Киритрон Стэйблкор
 */

package space.kiritron.pixel.logger;

import java.io.PrintWriter;
import java.io.StringWriter;

public class stackTraceConverter {
    /**
     * Возвращает строку StackTrace исключения.
     * @param throwable Исключение, StackTrace которого нужно преобразовать в String.
     * @return Строку StackTrace! Запишите это теперь в лог.
     */
    public static String convert(Throwable throwable) {
        StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        return sw.toString();
    }
}
