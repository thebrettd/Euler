package main.java;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/18/12
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class LowerCommonAncestor {

    public static void main(String[] args){

        IntNode bst = constructBST();

        IntNode lca = findLowestCommonAncestor(4,14, bst);
        if (lca == null){
            System.out.println("Could not find LCA in tree");
        }else{
            System.out.println("Val of the lca: " + lca.getVal());
        }

    }

    public static IntNode findLowestCommonAncestor(int val1, int val2, IntNode root) {
        int currVal = root.getVal();
        if (currVal >= val1 && currVal >= val2){
            findLowestCommonAncestor(val1,val2,root.getLeftChild());
        }else{

        }


        return null;
    }

    private static IntNode constructBST() {
        IntNode twenty = new IntNode(20);
        IntNode eight = new IntNode(8);
        IntNode four = new IntNode(4);
        IntNode twelve = new IntNode(12);
        IntNode ten = new IntNode(10);
        IntNode fourteen = new IntNode(14);
        IntNode twentyTwo = new IntNode(22);

        twenty.setLeftChild(eight);
        twenty.setRightChild(twentyTwo);

        eight.setLeftChild(four);
        eight.setRightChild(twelve);

        twelve.setLeftChild(ten);
        twelve.setRightChild(fourteen);

        return twenty;
    }
}
