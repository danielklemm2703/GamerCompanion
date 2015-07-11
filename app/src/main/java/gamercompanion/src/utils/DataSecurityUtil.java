package gamercompanion.src.utils;

import android.util.Base64;

import java.nio.charset.Charset;

/**
 * provides encrypt and decrypt functions
 */
public final class DataSecurityUtil {

    public static final String encrypt(String plainText)
    {
        byte[] plainBytes = plainText.getBytes(Charset.forName("UTF-8"));
        byte[] encodedBytes = Base64.encode(plainBytes, Base64.DEFAULT);
        return new String(encodedBytes);
    }

    public static final String decrypt(String cypherText)
    {
        byte[] decodedBytes = Base64.decode(cypherText.getBytes(Charset.forName("UTF-8")), Base64.DEFAULT);
        return new String(decodedBytes);
    }
}
