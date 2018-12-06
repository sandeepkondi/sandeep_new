package com.beyontec.mol.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beyontec.mol.exception.ApplicationException;
import com.beyontec.mol.exception.ErrorCode;

public final class CryptoUtil {

    private static final Logger logger = LoggerFactory.getLogger(CryptoUtil.class);
    private static final String ENC_UTF8 = "UTF-8";
    private static final String DIGEST_ALG = "SHA-256";
    private static final String CIPHER_ALG = "AES/CBC/PKCS5Padding";
    private static final String SECRET_KEY_ALG = "AES";
    private static final String SECRET_KEY = "##!/M/E*@/t:15";

    private static MessageDigest msgDigest = null;
    private static SecretKeySpec secretKeySpec = null;

    static {
        try {
            msgDigest = MessageDigest.getInstance(DIGEST_ALG);
            byte[] key = msgDigest.digest(SECRET_KEY.getBytes(ENC_UTF8));
            secretKeySpec = new SecretKeySpec(key, SECRET_KEY_ALG);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            logger.error("Encryption Algorithm Error : ", e);
        }
    }

    public static String encrypt(String rawText) {
        if (rawText == null) { return rawText; }
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALG);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            byte[] cipherText = cipher.doFinal(rawText.getBytes(ENC_UTF8));
            return DatatypeConverter.printHexBinary(cipherText);
        } catch (Exception e) {
            logger.error("Encryption Error : ", e);
            throw new ApplicationException(ErrorCode.ENCRYPTION_ERROR);
        }
    }

    public static String decrypt(String encodedText) {
        if (encodedText == null) { return encodedText; }
        try {
            byte[] encryptedText = DatatypeConverter.parseHexBinary(encodedText);
            Cipher cipher = Cipher.getInstance(CIPHER_ALG);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            byte[] cipherText = cipher.doFinal(encryptedText);
            return new String(cipherText);
        } catch (Exception e) {
            logger.error("Decryption Error : ", e);
            throw new ApplicationException(ErrorCode.DECRYPTION_ERROR);
        }
    }
}
