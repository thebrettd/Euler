/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/18/12
 * Time: 8:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class PreOrderTraversal{

    public static void main(String[] args){
        IntNode root = constructTree1();

        preOrderTraverse(root);

    }

    private static void preOrderTraverse(IntNode root) {
        System.out.println(root.getVal());

        IntNode leftChild = root.getLeftChild();
        if (leftChild != null)
            preOrderTraverse(leftChild);

        IntNode rightChild = root.getRightChild();
        if (rightChild != null)
            preOrderTraverse(rightChild);
    }

    private static IntNode constructTree1() {
        IntNode oneHundred = new IntNode(100);
        IntNode oneHundredFifty = new IntNode(150);
        IntNode fifty = new IntNode(50);

        oneHundred.setLeftChild(fifty);
        oneHundred.setRightChild(oneHundredFifty);

        IntNode twentyFive = new IntNode(25);
        IntNode seventyFive = new IntNode(75);
        fifty.setLeftChild(twentyFive);
        fifty.setRightChild(seventyFive);

        IntNode oneHundredTwentyFive = new IntNode(125);
        IntNode oneHundredSeventyFive = new IntNode(175);
        oneHundredFifty.setLeftChild(oneHundredTwentyFive);
        oneHundredFifty.setRightChild(oneHundredSeventyFive);

        IntNode oneHundredTen = new IntNode(110);
        oneHundredTwentyFive.setLeftChild(oneHundredTen);

        return oneHundred;

    }

}
