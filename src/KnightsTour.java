import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 11/18/12
 * Time: 7:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class KnightsTour {

    private ArrayList<Move> moves;
    private Board board;

    public KnightsTour(int numRanksAndCols) {
        this.moves = new ArrayList<Move>();
        this.board = new Board(numRanksAndCols, numRanksAndCols);
        this.board.getBoardArray()[0][0] = true;
    }

    public static void main(String[] args) {

        Knight k = new Knight(0, 0);

        KnightsTour kt = new KnightsTour(5);
        kt.findKnightsTour(k);

        Board cleanBoard = new Board(5, 5);
        int moveNum = 1;
        for (Move move : kt.moves) {
            System.out.println("Move: " + moveNum);
            doMove(cleanBoard, k, move);
            cleanBoard.printBoard(k);
            moveNum++;
        }
    }

    private boolean findKnightsTour(Knight knight) {
        if (this.board.getNumMoves() == this.board.getNumRanks() * this.board.getNumFiles()) {
            System.out.println("Solved!!");
            return true;
        } else {
            ArrayList<Move> allValidMoves = knight.getAllValidMoves(this.board);
            for (Move move : allValidMoves) {

                //Move the knight
                //System.out.println("Trying a move");
                doMove(this.board, knight, move);

                if (findKnightsTour(knight)) {
                    this.moves.add(move);
                    doMove(this.board, knight, move);
                    return true;
                }else{
                    undoMove(this.board, knight, move);
                }
            }
        }

        //No valid moves or they did not lead to a solution
        return false;
    }

    private static void undoMove(Board b, Knight knight, Move m) {
        //System.out.println("Got stuck, undoing move: " + b.getNumMoves());

        //Move the knight back
        knight.rank = m.oldRank;
        knight.file = m.oldFile;
        //Unmark the square
        b.getBoardArray()[m.newRank][m.newFile] = false;
        //Decrease move count
        b.decrementMoves();
        //b.printBoard(knight);
    }

    private static void doMove(Board b, Knight knight, Move m) {
        //Move the knight
        knight.rank = m.newRank;
        knight.file = m.newFile;
        //Mark the square
        b.getBoardArray()[knight.rank][knight.file] = true;
        //Increase move count
        b.incrementMoves();
        //b.printBoard(knight);
    }
}

