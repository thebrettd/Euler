import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 11/19/12
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Knight {

    int rank;    //horizontal
    int file;    //verticle

    public Knight(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    //return a list of all the places the knight can move - do not return places the knight has already visited
    public ArrayList<Move> getAllValidMoves(Board b) {
        ArrayList<Move> allValidMoves = new ArrayList<Move>();
        //System.out.println("Computing valid moves for knight in rank: " + this.rank + " file: " + this.file);

        ArrayList<Move> allPossibleMoves = this.getAllPossibleMoves(b);
        for (Move move : allPossibleMoves) {
            if (!b.hasBeenVisited(move)) {
                allValidMoves.add(move);
                //System.out.println("Found valid move -- newRank: " + move.newRank + " newFile:" + move.newFile);
            }
        }
        return allValidMoves;
    }

    // Return all valid moves the knight can make from its current position
    public ArrayList<Move> getAllPossibleMoves(Board b) {
        ArrayList<Move> moves = new ArrayList<Move>();

        // right one, up 2
        if (this.rank+1 < b.getNumRanks() && this.file+2 < b.getNumFiles()){
            moves.add(new Move(this.rank+1, this.file+2));
        }

        //left one, up 2
        if (this.rank-1 >= 0 && this.file+2 < b.getNumFiles()){
            moves.add(new Move(this.rank-1,this.file+2));
        }

        //right one,down 2
        if (this.rank+1 < b.getNumRanks() && this.file-2 >=0){
            moves.add(new Move(this.rank+1,this.file-2));
        }

        //left one,down 2
        if (this.rank-1 >=0 && this.file-2 >= 0){
            moves.add(new Move(this.rank-1,this.file-2));
        }

        //right 2 up one
        if (this.rank+2 < b.getNumRanks() && this.file+1 < b.getNumFiles()){
            moves.add(new Move(this.rank+2,this.file+1));
        }

        //right 2 down one
        if (this.rank+2 < b.getNumRanks() && this.file-1 >= 0){
            moves.add(new Move(this.rank+2,this.file-1));
        }

        //left 2 up one
        if (this.rank-2 >= 0 && this.file+1 < b.getNumFiles()){
            moves.add(new Move(this.rank-2,this.file+1));
        }

        //left 2 down one
        if (this.rank-2 >=0 && this.file-1 >=0){
            moves.add(new Move(this.rank-2,this.file-1));
        }

        return moves;
    }

}
