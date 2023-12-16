package com.blockchain;

import com.Presistence.GetData;
import com.Presistence.RandomHashGenerator;
import com.Presistence.StringHasher;

public class test {
    public static void main(String[] args) {  

        Blockchain javacoin = new Blockchain();
        GetData get = new GetData();
        String cus = get.getData();
        // ------------------------------------------------------------------------------
        // Random produces the first 64 characters for the file address
        RandomHashGenerator ran = new RandomHashGenerator();
        String last_id = ran.generateRandomHash();

        // Hash user information
        StringHasher hasher = new StringHasher();
        String first_id = hasher.hashString(cus);
        // 128 Temperament to the file indicator




        // -------------------------------------------------------------------------------
        // Random produces the first 64 characters for the file address
        RandomHashGenerator ran2 = new RandomHashGenerator();
        String last_id2 = ran2.generateRandomHash();

        // Hash user information
        StringHasher hasher2 = new StringHasher();
        String first_id2 = hasher2.hashString(cus);
        // 128 Temperament to the file indicator

        //testing
        
        Block file1 = new Block(last_id + first_id,"");
        Block file2 = new Block(last_id2 + first_id2,"");
        javacoin.addBlock(file1);
        javacoin.addBlock(file2);
        for(Block block : javacoin.chain){
          System.out.println("Block Data: " + block.data);
          System.out.println("ID Block: "+ block.hash);
        }
      }
}
