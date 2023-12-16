package com.Presistence;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringHasher {

    public static String hashString(String input) {
        try {
            // Use SHA-256 algorithm for the purpose of hash
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // convert input chain into byte and update digest
            md.update(input.getBytes());

            // string to represent the hash code
            StringBuilder hashBuilder = new StringBuilder();

            // Convert each byte into HEX format and add to the hash string
            for (byte b : md.digest()) {
                hashBuilder.append(String.format("%02x", b));
            }

            return hashBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}



