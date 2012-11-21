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
    private Knight knight;

    public KnightsTour(int numRanksAndCols, int startingRank, int startingFile) {
        //Create objects
        this.moves = new ArrayList<Move>();
        this.board = new Board(numRanksAndCols, numRanksAndCols);

        //Create a knight and a starting "move" to place the knight on the board
        this.knight = new Knight(startingRank,startingFile);
        Move startingMove = new Move(startingRank,startingFile);
        doMove(board,knight,startingMove);

    }

    public static void main(String[] args) {

        KnightsTour kt = new KnightsTour(5, Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        kt.findKnightsTour();

        Board cleanBoard = new Board(5, 5);
        /*
        int moveNum = 1;
        for (Move move : kt.moves) {
            System.out.println("Move: " + moveNum);
            doMove(cleanBoard, k, move);
            cleanBoard.printBoard(k);
            moveNum++;
        }*/
    }

    private boolean findKnightsTour() {
        if (this.moves.size() == this.board.getNumRanks() * this.board.getNumFiles()) {
            System.out.println("Solved!!");
            return true;
        } else {
            ArrayList<Move> allValidMoves = this.knight.getAllValidMoves(this.board);
            for (Move move : allValidMoves) {
                //System.out.println("Trying a move");
                doMove(this.board, knight, move);

                if (findKnightsTour()) {
                    return true;
                }else{
                    undoMove(this.board, knight, move);
                }
            }
        }

        //No valid moves or they did not lead to a solution
        return false;
    }

    private void undoMove(Board b, Knight knight, Move m) {
        //System.out.println("Got stuck, undoing move: " + b.getNumMoves());
        this.moves.remove(m);

        //Move the knight back
        knight.rank = m.oldRank;
        knight.file = m.oldFile;
        //Unmark the square
        b.getBoardArray()[m.newRank][m.newFile] = false;

        //b.printBoard(knight);
    }

    private void doMove(Board b, Knight knight, Move m) {
        //Add the move to the list of moves
        this.moves.add(m);

        //Update the knights position
        knight.rank = m.newRank;
        knight.file = m.newFile;

        //Mark the square as visited on the board
        b.getBoardArray()[knight.rank][knight.file] = true;

        //b.printBoard(knight);
    }
}

