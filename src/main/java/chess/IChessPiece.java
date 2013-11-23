package chess;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 11/20/12
 * Time: 10:32 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IChessPiece {

    public void isMoveValid(Move move, Board board);

    //public ArrayList<Move> getAllValidMoves(Board board);

    public void doMove(Move move);
    public void undoMove(Move move);

    public String toString();


}
