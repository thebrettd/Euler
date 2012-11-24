package chess;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 11/19/12
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Knight extends ChessPiece {

    private static final String FULLNAME = "Knight";
    private static final String SHORTNAME = "K";

    public Knight(ChessCoordinate startingPosition) {
        super(FULLNAME, "Player1",startingPosition);
    }

    @Override
    public void isMoveValid(Move move, Board board) {
        //todo
    }


    //return a list of all the places the knight can move - do not return places the knight has already visited
    public ArrayList<ChessCoordinate> getAllValidMoves(Board b) {
        ArrayList<ChessCoordinate> allValidMoves = new ArrayList<ChessCoordinate>();
        //System.out.println("Computing valid moves for knight in rank: " + this.rank + " file: " + this.position.file);

        ArrayList<ChessCoordinate> allPossibleMoves = this.getAllPossibleMoves(b);
        for (ChessCoordinate coord : allPossibleMoves) {
            if (!b.hasBeenVisited(coord)) {
                allValidMoves.add(coord);
                //System.out.println("Found valid move -- newRank: " + move.newRank + " newFile:" + move.newFile);
            }
        }
        return allValidMoves;
    }

    // Return all possible ChessCoordinates the knight can make from its current position
    public ArrayList<ChessCoordinate> getAllPossibleMoves(Board b) {
        ArrayList<ChessCoordinate> moves = new ArrayList<ChessCoordinate>();

        // right one, up 2
        if (this.position.rank + 1 < b.getNumRanks() && this.position.file + 2 < b.getNumFiles()) {
            moves.add(new ChessCoordinate(this.position.rank + 1, this.position.file + 2));
        }

        //left one, up 2
        if (this.position.rank - 1 >= 0 && this.position.file + 2 < b.getNumFiles()) {
            moves.add(new ChessCoordinate(this.position.rank - 1, this.position.file + 2));
        }

        //right one,down 2
        if (this.position.rank + 1 < b.getNumRanks() && this.position.file - 2 >= 0) {
            moves.add(new ChessCoordinate(this.position.rank + 1, this.position.file - 2));
        }

        //left one,down 2
        if (this.position.rank - 1 >= 0 && this.position.file - 2 >= 0) {
            moves.add(new ChessCoordinate(this.position.rank - 1, this.position.file - 2));
        }

        //right 2 up one
        if (this.position.rank + 2 < b.getNumRanks() && this.position.file + 1 < b.getNumFiles()) {
            moves.add(new ChessCoordinate(this.position.rank + 2, this.position.file + 1));
        }

        //right 2 down one
        if (this.position.rank + 2 < b.getNumRanks() && this.position.file - 1 >= 0) {
            moves.add(new ChessCoordinate(this.position.rank + 2, this.position.file - 1));
        }

        //left 2 up one
        if (this.position.rank - 2 >= 0 && this.position.file + 1 < b.getNumFiles()) {
            moves.add(new ChessCoordinate(this.position.rank - 2, this.position.file + 1));
        }

        //left 2 down one
        if (this.position.rank - 2 >= 0 && this.position.file - 1 >= 0) {
            moves.add(new ChessCoordinate(this.position.rank - 2, this.position.file - 1));
        }

        return moves;
    }

    @Override
    public String toString(){
        return SHORTNAME;
    }

}
