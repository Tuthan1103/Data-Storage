package com.Presistence;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RandomHashGenerator {
    public static String generateRandomHash() {
        try {
// Use SHA-256 algorithm for the purpose of hash
            MessageDigest md = MessageDigest.getInstance("SHA-256");
// Create some random to make salt (salt)
            SecureRandom secureRandom = new SecureRandom();
            byte[] salt = new byte[16];
            secureRandom.nextBytes(salt);
// string to represent the hash code
            StringBuilder hashBuilder = new StringBuilder();
// convert each byte into HEX format and add to the hash
            for (byte b : md.digest(salt)) {
                hashBuilder.append(String.format("%02x", b));
            }
// make sure the hash code has a length of 64 characters
            while (hashBuilder.length() < 64) {
                hashBuilder.append("0");
            }
            return hashBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
