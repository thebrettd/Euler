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
        this.board = new Board(numRanksAndCols,numRanksAndCols);
        this.board.getBoardArray()[0][0] = true;
    }

    public static void main(String[] args) {

        Knight k = new Knight(0, 0);

        KnightsTour kt = new KnightsTour(5);
        kt.findKnightsTour(k);

        Board cleanBoard = new Board(5,5);
        int moveNum = 1;
        for (Move move : kt.moves) {
            System.out.println("Move: " + moveNum);
            doMove(cleanBoard, k, move);
            cleanBoard.printBoard(k);
            moveNum++;
        }
    }

    private boolean findKnightsTour(Knight knight) {
        if (this.board.getNumMoves() == this.board.getNumRanks() * this.board.getNumFiles() ) {
            //moves.add(m);
            System.out.println("Solved!!");
            return true;
        } else {
            ArrayList<Move> allValidMoves = knight.getAllValidMoves(this.board);
            if (allValidMoves.size() > 0) {
                //If valid move exists
                for (Move vm : allValidMoves) {
                    int oldRank = knight.rank;
                    int oldFile = knight.file;

                    //Move the knight
                    //System.out.println("Trying a move");
                    doMove(this.board, knight, vm);

                    if (findKnightsTour(knight)) {
                        this.moves.add(vm);
                        doMove(this.board,knight,vm);
                        return true;
                    }
                    undoMove(this.board,knight,vm,oldRank,oldFile);
                }
            }else{
                return false;
            }
        }

        //System.out.println("Could not find solution for given starting position");
        return false;
    }

    private static void undoMove(Board b, Knight knight, Move m, int oldRank, int oldFile) {
        //System.out.println("Got stuck, undoing move: " + b.getNumMoves());

        knight.rank = oldRank;
        knight.file = oldFile;
        b.getBoardArray()[m.newRank][m.newFile] = false;
        b.decrementMoves();
        //b.printBoard(knight);
    }

    private static void doMove(Board b, Knight knight, Move m) {
        knight.rank = m.newRank;
        knight.file = m.newFile;
        b.getBoardArray()[knight.rank][knight.file] = true;
        b.incrementMoves();
        //b.printBoard(knight);
    }
}

