package cinema.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HashUtil {
    public static String hashPassword(String password, byte[] salt) {
        StringBuilder stringBuilder = new StringBuilder();
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(salt);
            byte[] hash = messageDigest.digest(password.getBytes());
            for (byte b : hash) {
                stringBuilder.append(String.format("%02x", b));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Select correct algorithm");
        }
    }

    public static byte[] getSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[13];
        secureRandom.nextBytes(salt);
        return salt;
    }
}
