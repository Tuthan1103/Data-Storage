package com.Presistence;

public class Main {
    public static void main(String[] args) {
        // get data from database
        GetData get = new GetData();
        String cus = get.getData();
        // Random produces the first 64 characters for the file address
        RandomHashGenerator ran = new RandomHashGenerator();
        String last_id = ran.generateRandomHash();
        System.err.println(last_id);

        // Hash user information
        StringHasher hasher = new StringHasher();
        String first_id = hasher.hashString(cus);
        System.err.println(first_id);
        // 128 Temperament to the file indicator
        System.err.println(last_id + first_id);

         
    }
}