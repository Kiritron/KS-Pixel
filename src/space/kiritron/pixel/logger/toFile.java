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

public class toFile {
    private static void LogFileWriter(String prefixLogFile, String log_messageFile) throws IOException {
        File logFile;
        if (prefixLogFile.equals("")) {
            logFile = new File(GetPathOfAPP.GetPathWithSep() + "logs" + GetPathOfAPP.GetSep() + GDate.GetDate + ".log");
        } else {
            logFile = new File(GetPathOfAPP.GetPathWithSep() + "logs" + GetPathOfAPP.GetSep() + prefixLogFile + "-" + GDate.GetDate + ".log");
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
        String lineSeparator = System.getProperty("line.separator");
        writer.write(log_messageFile + lineSeparator);
        writer.flush();
        writer.close();
    }

    /**
     * Запись лог файла с префиксом в названии файла.
     * @param prefixLogFile Префикс лог файла.
     * @param log_message Сообщение, которое нужно записать в лог файл.
     * @return результат выполнения. Если равно TRUE, то всё в порядке, а если FALSE, то что-то пошло не так.
     */
    public static void WriteLogWithPrefix(String prefixLogFile, String log_message) {
        try {
            LogFileWriter(prefixLogFile, log_message);
        } catch (IOException e) {
            throw new RuntimeException(new IOException("Не удалось создать лог файл c префиксом " + prefixLogFile + ". Ошибка: " + e.getMessage()));
        }
    }

    /**
     * Запись лог файла, но уже без префикса в названии лог файла.
     * @param log_message Сообщение, которое нужно записать в лог файл.
     * @return результат выполнения. Если равно TRUE, то всё в порядке, а если FALSE, то что-то пошло не так.
     */
    public static void WriteLogNoPrefix(String log_message) {
        try {
            LogFileWriter("", log_message);
        } catch (IOException e) {
            throw new RuntimeException(new IOException("Не удалось создать лог файл без префикса. Ошибка: " + e.getMessage()));
        }
    }
}
