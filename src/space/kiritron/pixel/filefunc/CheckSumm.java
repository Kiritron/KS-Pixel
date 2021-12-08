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

package space.kiritron.pixel.filefunc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Киритрон Стэйблкор
 */

public class CheckSumm {
    /**
     * Генерация контрольной суммы.
     * @param Method Алгоритм, по которому нужно производить операцию хеширования. В библиотеке в классе space.kiritron.pixel.HashGenerator доступны: MD5, SHA1, SHA256, SHA384, SHA512. Можете использовать и свой параметр, если Вы понимаете, что делаете.
     * @param FilePath Путь до файла.
     * @return контрольную сумму в выбранном алгоритме.
     */

    public static String Gen(String Method, String FilePath) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(Method);
        InputStream fis = new FileInputStream(FilePath);
        int n = 0;
        byte[] buffer = new byte[8192];
        while (n != -1) {
            n = fis.read(buffer);
            if (n > 0) {
                digest.update(buffer, 0, n);
            }
        }

        BigInteger Big = new BigInteger(1, digest.digest());
        String OUT = Big.toString(16);
        while (OUT.length() < 32) OUT += "0" + OUT;

        return Big.toString(16);
    }
}
