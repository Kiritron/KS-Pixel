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

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * @author Киритрон Стэйблкор
 */

/*
 * Киритрон: Оооочень странно реализованный класс. Я уверен, что можно сделать более сжатый вариант, но у меня сходу не получилось.
 */

public class HttpClient {
    /**
     * Получить содержимое по URL адресу.
     * @param URL URL-адрес, по которому нужно получить содержимое.
     * @return Контент, который был получен по URL-адресу.
     */
    public static String getContent(String URL) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new URL(URL).openStream()));
        String inputLine = "";
        StringBuilder out = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            out.append(inputLine);
        }

        in.close();
        return out.toString();
    }

    /**
     * Отправить данные по методу POST.
     * @param SSL использовать ли SSL.
     * @param URL URL-адрес, на который нужно отправить данные.
     * @param Message Данные, которые нужно отправить.
     * @param UserAgent Имя клиента в шапке запроса. Укажите null, если не хотите указывать.
     * @param ContentType Тип контента в шапке запроса. Укажите null, если не хотите указывать.
     * @return Контент, который был получен по URL-адресу.
     */
    public static String sendPost(boolean SSL, String URL, String Message, String UserAgent, String ContentType) throws Exception {
        if (SSL) {
            return sendPost_SSL(URL, Message, UserAgent, ContentType);
        } else {
            return sendPost_noSSL(URL, Message, UserAgent, ContentType);
        }
    }

    /**
     * Отправить данные по методу GET.
     * @param SSL использовать ли SSL.
     * @param URL URL-адрес, на который нужно отправить данные.
     * @param Message Данные, которые нужно отправить.
     * @param UserAgent Имя клиента в шапке запроса. Укажите null, если не хотите указывать.
     * @param ContentType Тип контента в шапке запроса. Укажите null, если не хотите указывать.
     * @return Контент, который был получен по URL-адресу.
     */
    public static String sendGet(boolean SSL, String URL, String Message, String UserAgent, String ContentType) throws Exception {
        if (SSL) {
            return sendGet_SSL(URL, Message, UserAgent, ContentType);
        } else {
            return sendGet_noSSL(URL, Message, UserAgent, ContentType);
        }
    }

    private static String sendGet_SSL(String URL, String Message, String UserAgent, String ContentType) throws Exception {
        HttpsURLConnection httpClient;
        httpClient = (HttpsURLConnection) new URL(URL + "?" + Message).openConnection();

        httpClient.setRequestMethod("GET");

        if (UserAgent != null) {
            httpClient.setRequestProperty("User-Agent", UserAgent);
        }

        if (ContentType != null) {
            httpClient.setRequestProperty("Content-Type", ContentType);
        }

        httpClient.setDoOutput(true);

        int numtries = 3;
        while(numtries-- != 0) {
            try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
                wr.writeBytes(Message);
                wr.flush();
                break;
            } catch (UnknownHostException e) {
                continue;
            }
        }

        if (numtries == 0) {
            throw new UnknownHostException("Не удалось соединиться с адресом " + URL);
        }

        int responseCode = httpClient.getResponseCode();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            if (responseCode == 200) {
                return response.toString();
            } else {
                throw new Exception("Сервер по адресу " + URL + " вернул код ответа отличный от кода 200(OK), а точнее - " + responseCode + ".");
            }
        }
    }

    private static String sendGet_noSSL(String URL, String Message, String UserAgent, String ContentType) throws Exception {
        HttpsURLConnection httpClient;
        httpClient = (HttpsURLConnection) new URL(URL + "?" + Message).openConnection();

        httpClient.setRequestMethod("GET");

        if (UserAgent != null) {
            httpClient.setRequestProperty("User-Agent", UserAgent);
        }

        if (ContentType != null) {
            httpClient.setRequestProperty("Content-Type", ContentType);
        }

        httpClient.setDoOutput(true);

        int numtries = 3;
        while(numtries-- != 0) {
            try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
                wr.writeBytes(Message);
                wr.flush();
                break;
            } catch (UnknownHostException e) {
                continue;
            }
        }

        if (numtries == 0) {
            throw new UnknownHostException("Не удалось соединиться с адресом " + URL);
        }

        int responseCode = httpClient.getResponseCode();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            if (responseCode == 200) {
                return response.toString();
            } else {
                throw new Exception("Сервер по адресу " + URL + " вернул код ответа отличный от кода 200(OK), а точнее - " + responseCode + ".");
            }
        }
    }

    private static String sendPost_SSL(String URL, String Message, String UserAgent, String ContentType) throws Exception {
        HttpsURLConnection httpClient;
        httpClient = (HttpsURLConnection) new URL(URL).openConnection();

        httpClient.setRequestMethod("POST");

        if (UserAgent != null) {
            httpClient.setRequestProperty("User-Agent", UserAgent);
        }

        if (ContentType != null) {
            httpClient.setRequestProperty("Content-Type", ContentType);
        }

        httpClient.setDoOutput(true);

        int numtries = 3;
        while(numtries-- != 0) {
            try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
                wr.writeBytes(Message);
                wr.flush();
                break;
            } catch (UnknownHostException e) {
                continue;
            }
        }

        if (numtries == 0) {
            throw new UnknownHostException("Не удалось соединиться с адресом " + URL);
        }

        int responseCode = httpClient.getResponseCode();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            if (responseCode == 200) {
                return response.toString();
            } else {
                throw new Exception("Сервер по адресу " + URL + " вернул код ответа отличный от кода 200(OK), а точнее - " + responseCode + ".");
            }
        }
    }

    private static String sendPost_noSSL(String URL, String Message, String UserAgent, String ContentType) throws Exception {
        HttpURLConnection httpClient;
        httpClient = (HttpURLConnection) new URL(URL).openConnection();

        httpClient.setRequestMethod("POST");

        if (UserAgent != null) {
            httpClient.setRequestProperty("User-Agent", UserAgent);
        }

        if (ContentType != null) {
            httpClient.setRequestProperty("Content-Type", ContentType);
        }

        httpClient.setDoOutput(true);

        int numtries = 3;
        while(numtries-- != 0) {
            try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
                wr.writeBytes(Message);
                wr.flush();
                break;
            } catch (UnknownHostException e) {
                continue;
            }
        }

        if (numtries == 0) {
            throw new UnknownHostException("Не удалось соединиться с адресом " + URL);
        }

        int responseCode = httpClient.getResponseCode();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            if (responseCode == 200) {
                return response.toString();
            } else {
                throw new Exception("Сервер по адресу " + URL + " вернул код ответа отличный от кода 200(OK), а точнее - " + responseCode + ".");
            }
        }
    }
}
