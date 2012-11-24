package chess;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 11/18/12
 * Time: 7:01 PM
 */
public class KnightsTour {

    public ArrayList<Move> getMoves() {
        return moves;
    }

    private ArrayList<Move> moves;
    private Board board;
    private Knight knight;

    public KnightsTour(int numRanksAndCols, int startingRank, int startingFile) {
        //Create objects
        this.moves = new ArrayList<Move>();
        this.board = new Board(numRanksAndCols, numRanksAndCols);

        //Create a knight and a starting "move" to place the knight on the board
        this.knight = new Knight(new ChessCoordinate(-1,-1));
        Move startingMove = new Move(this.knight, new ChessCoordinate(startingRank,startingFile));
        knight.doMove(startingMove);
        this.moves.add(startingMove);
        this.board.getBoardArray()[startingMove.newPosition.rank][startingMove.newPosition.file] = true;

    }

    public void printMovesList(){
        for (Move move : this.moves) {
            move.print();
        }
    }

    public static void main(String[] args) {

        KnightsTour kt = new KnightsTour(5, Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        kt.findKnightsTour();
        kt.printMovesList();

    }

    public boolean findKnightsTour() {
        if (this.moves.size() == this.board.getNumRanks() * this.board.getNumFiles()) {
            System.out.println("Solved!!");
            return true;
        } else {
            ArrayList<ChessCoordinate> allValidMoves = this.knight.getAllValidMoves(this.board);
            for (ChessCoordinate newPosition : allValidMoves) {

                //System.out.println("Trying a move");
                Move move = new Move(knight,knight.position, newPosition);

                this.moves.add(move);

                //Update the knights position
                knight.doMove(move);

                //Mark the square as visited on the board
                this.board.getBoardArray()[move.newPosition.rank][move.newPosition.file] = true;

                //If this new configurations leads to a solution, return true, otherwise undo it
                if (findKnightsTour()){
                    return true;
                }else{
                    moves.remove(move);
                    //System.out.println("Got stuck, remove move: " + move);
                    knight.undoMove(move);

                    //Unmark the square
                    this.board.getBoardArray()[move.newPosition.rank][move.newPosition.file] = false;
                }
            }
        }

        //No valid moves or they did not lead to a solution
        return false;
    }
}

