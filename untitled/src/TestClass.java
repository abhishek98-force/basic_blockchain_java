import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        List<Block> blockList = Block.blockChain;
        blockList.add(new Block("0","This is the first block"));
        blockList.add(new Block(blockList.get(0).getPreviousHash(),"This is the second block"));
        blockList.add(new Block(blockList.get(1).getPreviousHash(),"This is the third block"));
        blockList.add(new Block(blockList.get(2).getPreviousHash(),"This is the fourth block"));

    }
}
