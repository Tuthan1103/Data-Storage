package com.blockchain;
import java.util.Scanner;
import com.Presistence.GetData;
import com.Presistence.RandomHashGenerator;
import com.Presistence.StringHasher;

// public class test {
//     public static void main(String[] args) {  

//         Blockchain javacoin = new Blockchain();
//         GetData get = new GetData();
//         String cus = get.getData();
//         // ------------------------------------------------------------------------------
//         // Random produces the first 64 characters for the file address
//         RandomHashGenerator ran = new RandomHashGenerator();
//         String last_id = ran.generateRandomHash();

//         // Hash user information
//         StringHasher hasher = new StringHasher();
//         String first_id = hasher.hashString(cus);
//         // 128 Temperament to the file indicator




//         // -------------------------------------------------------------------------------
//         // Random produces the first 64 characters for the file address
//         RandomHashGenerator ran2 = new RandomHashGenerator();
//         String last_id2 = ran2.generateRandomHash();

//         // Hash user information
//         StringHasher hasher2 = new StringHasher();
//         String first_id2 = hasher2.hashString(cus);
//         // 128 Temperament to the file indicator

//         //testing
        
//         Block file1 = new Block(last_id + first_id,"");
//         Block file2 = new Block(last_id2 + first_id2,"");
//         javacoin.addBlock(file1);
//         javacoin.addBlock(file2);
//         for(Block block : javacoin.chain){
//           System.out.println("Block Data: " + block.data);
//           System.out.println("ID Block: "+ block.hash);
//         }
//       }
// }


public class test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Blockchain javacoin = new Blockchain();
        GetData get = new GetData();
        String cus = get.getData();

        String continueCondition = "y";

        while (continueCondition.equalsIgnoreCase("y")) {
            // Sử dụng một mảng để lưu trữ các luồng
            Thread[] threads = new Thread[1];

            for (int i = 0; i < threads.length; i++) {
                final int index = i;
                threads[i] = new Thread(() -> {
                    // Random produces the first 64 characters for the file address
                    RandomHashGenerator ran = new RandomHashGenerator();
                    String last_id = ran.generateRandomHash();

                    // Hash user information
                    StringHasher hasher = new StringHasher();
                    String first_id = hasher.hashString(cus);

                    // Create a new block and add it to the blockchain
                    Block newBlock = new Block(last_id + first_id, "");
                    javacoin.addBlock(newBlock);

                    System.out.println("Block " + index + " added.");
                });
            }

            // Khởi động tất cả các luồng
            for (Thread thread : threads) {
                thread.start();
            }

            // Chờ cho tất cả các luồng hoàn thành
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // In thông tin của tất cả các block trong blockchain
            for (Block block : javacoin.chain) {
                System.out.println("Block Data: " + block.data);
                System.out.println("ID Block: " + block.hash);
            }

            // Hỏi người dùng có muốn tiếp tục không
            //System.out.print("Do you want to continue? (y/n): ");
            continueCondition = scanner.nextLine();
        }

        System.out.println("Program ended.");
    }
}
