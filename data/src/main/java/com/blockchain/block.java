package com.blockchain;
import java.util.ArrayList;
import java.util.Date;
import com.Presistence.StringHasher;

class Block {
  public String hash;
  public String previousHash;
  public String data; //our data will be a simple message.
  public long timeStamp; //as number of milliseconds since 1/1/1970.

  // Block Constructor.  
  public Block(String data,String previousHash ) {
    this.data = data;
    this.previousHash = previousHash;
    this.timeStamp = new Date().getTime();

    this.hash = calculateHash(); //Making use of a hash function.
  }

  //Calculate new hash based on blocks contents
  public String calculateHash() {
    String calculatedhash = StringHasher.hashString( 
      
      data 
    );
    return calculatedhash;
  }
}

class Blockchain{

  public ArrayList<Block> chain;

  public Blockchain() {
    chain = new ArrayList<Block>();
    // Create Genesis block
    chain.add(new Block("Genesis block", "0")); 
  }

  // returns the latest block
  public Block getLatestBlock(){
    return chain.get(chain.size() - 1);
  }
  
  // adds a new block to the chain
  public void addBlock(Block newBlock){
    
    newBlock.previousHash = getLatestBlock().hash;
    newBlock.hash = newBlock.calculateHash();
    
    chain.add(newBlock);
  }
  
}


