/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/18/12
 * Time: 8:47 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Node {
    private Node[] children;

    public Node(){

    }

    public int size(){
        return children.length;
    }

    public Node getChild(int index){
        return children[index];
    }

    public void setChild(Node child, int index){
        children[index] = child;
    }
}
