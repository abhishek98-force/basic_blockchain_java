import jdk.jshell.execution.Util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Block {

    static ArrayList<Block> blockChain = new ArrayList<>();
    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;

    public Block(String previousHash, String data){
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = createHash(previousHash,data,timeStamp);
    }

    public String createHash(String previousHash,String data, long timeStamp){
        return UtilityClass.converStringToHash(
                previousHash+
                        data+
                        String.valueOf(timeStamp)
        );
    }

    public void add(Block b){
        blockChain.add(b);
    }

    public List<Block> returnBlockChain(){
        return blockChain;
    }

    public String getPreviousHash(){
        return previousHash;
    }

    @Override
    public String toString(){
        return "Hash of block with data "+this.data+" is "+this.hash;
    }

}
