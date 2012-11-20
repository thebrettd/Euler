/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 11/18/12
 * Time: 7:06 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Piece {

    String owner;
    String name;

    public Piece(String name, String owner){
        this.name = name;
        this.owner = owner;
    }



}
