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

package space.kiritron.pixel.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * @author Киритрон Стэйблкор & Mkyong
 */

public class AES {
    private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";
    private static final int TAG_LENGTH_BIT = 128;
    private static final int IV_LENGTH_BYTE = 16;
    private static final int SALT_LENGTH_BYTE = 16;
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    /**
     * AES-256 шифрование текста.
     * @param message Сообщение, которое нужно зашифровать.
     * @param password Ключ, который нужно использовать для шифрования.
     * @return зашифрованные текст алгоритмом AES-256.
     */
    public static String encrypt(String message, String password) throws Exception {
        return Base64.getEncoder().encodeToString(encrypt_handler(message.getBytes(UTF_8), password));
    }

    /**
     * Дешифрование шифра от алгоритма AES-256
     * @param message Сообщение, которое нужно дешифровать.
     * @param password Ключ, который использовался для шифрования.
     * @return исходный(дешифрованный) текст.
     */
    public static String decrypt(String message, String password) throws Exception {
        return new String(decrypt_handler(message, password), UTF_8);
    }

    /**
     * AES-256 шифрование файла.
     * @param fromFile Путь до файла, который нужно зашифровать.
     * @param toFile Путь до файла, на месте которого будет зашифрованный вариант файла из fromFile. Если по данному пути файла нет, то он будет создан.
     * @param password Ключ, который нужно использовать для шифрования.
     */
    public static void encryptFile(String fromFile, String toFile, String password) throws Exception {
        byte[] fileContent = Files.readAllBytes(Paths.get(fromFile));
        byte[] encryptedText = encrypt_handler(fileContent, password);

        Path path = Paths.get(toFile);

        Files.write(path, encryptedText);
    }

    /**
     * AES-256 дешифрование файла.
     * @param fromFile Путь до файла, который нужно дезашифровать.
     * @param toFile Путь до файла, на месте которого будет исходный(дешифрованный) вариант файла из fromFile. Если по данному пути файла нет, то он будет создан.
     * @param password Ключ, который нужно использовать для шифрования.
     */
    public static void decryptFile(String fromFile, String toFile, String password) throws Exception {
        byte[] fileContent = Files.readAllBytes(Paths.get(fromFile));
        byte[] decryptedText = decrypt_handler(Base64.getEncoder().encodeToString(fileContent), password);

        Path path = Paths.get(toFile);

        Files.write(path, decryptedText);
    }

    private static byte[] encrypt_handler(byte[] pText, String password) throws Exception {
        byte[] salt = getRandomNonce(SALT_LENGTH_BYTE);
        byte[] iv = getRandomNonce(IV_LENGTH_BYTE);

        SecretKey aesKeyFromPassword = getAESKeyFromPassword(password.toCharArray(), salt);
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);

        cipher.init(Cipher.ENCRYPT_MODE, aesKeyFromPassword, new GCMParameterSpec(TAG_LENGTH_BIT, iv));

        byte[] cipherText = cipher.doFinal(pText);
        byte[] cipherTextWithIvSalt = ByteBuffer.allocate(iv.length + salt.length + cipherText.length).put(iv).put(salt).put(cipherText).array();

        return cipherTextWithIvSalt;
    }

    private static byte[] decrypt_handler(String cText, String password) throws Exception {
        byte[] decode = Base64.getDecoder().decode(cText.getBytes(UTF_8));
        ByteBuffer bb = ByteBuffer.wrap(decode);

        byte[] iv = new byte[IV_LENGTH_BYTE];
        bb.get(iv);

        byte[] salt = new byte[SALT_LENGTH_BYTE];
        bb.get(salt);

        byte[] cipherText = new byte[bb.remaining()];
        bb.get(cipherText);

        SecretKey aesKeyFromPassword = getAESKeyFromPassword(password.toCharArray(), salt);
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        cipher.init(Cipher.DECRYPT_MODE, aesKeyFromPassword, new GCMParameterSpec(TAG_LENGTH_BIT, iv));

        return cipher.doFinal(cipherText);
    }

    private static byte[] getRandomNonce(int numBytes) {
        byte[] nonce = new byte[numBytes];
        new SecureRandom().nextBytes(nonce);

        return nonce;
    }

    private static SecretKey getAESKeyFromPassword(char[] password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        KeySpec spec = new PBEKeySpec(password, salt, 65536, 256);
        SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

        return secret;
    }
}
