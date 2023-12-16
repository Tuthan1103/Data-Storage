package com.blockchain;

import com.Presistence.GetData;
import com.Presistence.RandomHashGenerator;
import com.Presistence.StringHasher;

public class test {
    public static void main(String[] args) {    
        Blockchain javacoin = new Blockchain();
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
    
        //testing
        javacoin.addBlock(new Block(last_id + first_id,""));
       
        for(Block block : javacoin.chain){
          System.out.println("Block Data: " + block.data);
          System.out.println("ID Block: "+ block.hash);
        }
      }
}
