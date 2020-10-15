/*
 * Copyright 2020 Kiritron's Space
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

package space.kiritron.pixel.filefunc;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @author Киритрон Стэйблкор
 */

public class FileDownloads {
    public static boolean NIO = true;
    public static boolean InputStream = false;


    /**
     * Скачивание файла по URL и его сохранение по указанному пути
     * @param URL URL адрес файла
     * @param filepath Адрес ФАЙЛА, в который будет записан скачиваемый файл. Если по этому адресу файла нет, он будет создан.
     * @param method Метод загрузки. Доступны NIO и InputStream. Можете использовать готовые переменные
     *               FileDownloads.NIO и FileDownloads.InputStream или true и false соответственно.
     */
    public static void downloadFromURL(String URL, String filepath, boolean method) throws IOException {
        if (method) {
            URL_downloadUsingNIO(new URL(URL), filepath);
        } else {
            URL_downloadUsingStream(new URL(URL), filepath);
        }
    }

    /*
     * Киритрон: Можно конечно оставить один метод скачивания файла,
     * но NIO и InputStream не замена друг другу. Каждый из них
     * применяется в зависимости от ситуации.
     */

    private static void URL_downloadUsingNIO(URL url, String file) throws IOException {
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

    private static void URL_downloadUsingStream(URL url, String file) throws IOException{
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1) {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
}
