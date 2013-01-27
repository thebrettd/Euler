/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/18/12
 * Time: 8:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntNode extends Node {
    private int val;

    private IntNode leftChild;
    private IntNode rightChild;

    public IntNode(int val){
        super();
        this.val = val;
    }

    public int getVal(){
        return this.val;
    }

    public IntNode getLeftChild(){
        return leftChild;
    }

    public void setLeftChild(IntNode leftChild){
        this.leftChild = leftChild;
    }

    public IntNode getRightChild(){
        return this.rightChild;
    }

    public void setRightChild(IntNode rightChild){
        this.rightChild = rightChild;
    }

}
