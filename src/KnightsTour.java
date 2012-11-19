import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 11/18/12
 * Time: 7:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class KnightsTour {

    public KnightsTour() {

    }


    private static class Board {

        private Boolean[][] boardArray;
        private int numRanks;
        private int numFiles;
        private int numMoves;

        private Board(int numRanks, int numFiles) {
            this.numRanks = numRanks;
            this.numFiles = numFiles;
            this.numMoves = 1;
            this.boardArray = new Boolean[numRanks][numFiles];
            for (int rank = 0; rank < this.numRanks; rank++) {
                for (int file = 0; file < this.numFiles; file++) {
                    this.boardArray[rank][file] = false;
                }
            }
        }

        public boolean hasBeenVisited(Move move) {
            return boardArray[move.newRank][move.newFile];
        }

        public void printBoard(Knight k) {
            for (int rank = 0; rank < this.numRanks ; rank++) {
                for (int file = 0; file < this.numFiles; file++) {
                    System.out.print("[");
                    char charToPrint = (k.rank == rank && k.file == file) ? 'K' : (boardArray[rank][file] ? 'x' : ' ');
                    //System.out.print(boardArray[i][j] ? 'x' : ' ');
                    System.out.print(charToPrint);
                    System.out.print("]");
                }
                System.out.println("\n");
            }
        }
    }

    private static class Move {
        int newRank;
        int newFile;

        private Move(int newRank, int newFile) {
            this.newRank = newRank;
            this.newFile = newFile;
        }
    }

    private static class Knight {
        int rank;    //horizontal
        int file;    //verticle

        private Knight(int rank, int file) {
            this.rank = rank;
            this.file = file;
        }

        //return a list of all the places the knight can move - do not return places the knight has already visited
        private ArrayList<Move> getAllValidMoves(Board b) {
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
        private ArrayList<Move> getAllPossibleMoves(Board b) {
            ArrayList<Move> moves = new ArrayList<Move>();

            // right one, up 2
            if (this.rank+1 < b.numRanks && this.file+2 < b.numFiles){
                moves.add(new Move(this.rank+1, this.file+2));
            }

            //left one, up 2
            if (this.rank-1 >= 0 && this.file+2 < b.numFiles){
                moves.add(new Move(this.rank-1,this.file+2));
            }

            //right one,down 2
            if (this.rank+1 < b.numRanks && this.file-2 >=0){
                moves.add(new Move(this.rank+1,this.file-2));
            }

            //left one,down 2
            if (this.rank-1 >=0 && this.file-2 >= 0){
                moves.add(new Move(this.rank-1,this.file-2));
            }

            //right 2 up one
            if (this.rank+2 < b.numRanks && this.file+1 < b.numFiles){
                moves.add(new Move(this.rank+2,this.file+1));
            }

            //right 2 down one
            if (this.rank+2 < b.numRanks && this.file-1 >= 0){
                moves.add(new Move(this.rank+2,this.file-1));
            }

            //left 2 up one
            if (this.rank-2 >= 0 && this.file+1 < b.numFiles){
                moves.add(new Move(this.rank-2,this.file+1));
            }

            //left 2 down one
            if (this.rank-2 >=0 && this.file-1 >=0){
                moves.add(new Move(this.rank-2,this.file-1));
            }

            return moves;
        }
    }

    public static void main(String[] args) {
        Board b = new Board(5,5);
        Knight k = new Knight(0, 0);
        b.boardArray[0][0] = true;
        ArrayList<Move> moves = new ArrayList<Move>();

        findKnightsTour(b, k, moves);

        Board cleanBoard = new Board(5,5);
        int moveNum = 1;
        for (Move move : moves) {
            System.out.println("Move: " + moveNum);
            doMove(cleanBoard, k, move);
            cleanBoard.printBoard(k);
            moveNum++;
        }

    }

    public static boolean findKnightsTour(Board b, Knight knight, ArrayList<Move> moves) {
        if (b.numMoves == b.numRanks * b.numFiles) {
            System.out.println("Solved!!");
            return true;
        } else {
            ArrayList<Move> allValidMoves = knight.getAllValidMoves(b);
            if (allValidMoves.size() > 0) {
                //If valid move exists
                for (Move m : allValidMoves) {
                    int oldRank = knight.rank;
                    int oldFile = knight.file;

                    //Move the knight
                    //System.out.println("Trying a move");
                    doMove(b, knight, m);

                    if (findKnightsTour(b, knight, moves)) {
                        moves.add(m);
                        return true;
                    }
                    undoMove(b,knight,m,oldRank,oldFile);
                }
            }else{
                return false;
            }

        }

        //System.out.println("Could not find solution for given starting position");
        return false;
    }

    private static void undoMove(Board b, Knight knight, Move m, int oldRank, int oldFile) {
        //System.out.println("Got stuck, undoing move: " + b.numMoves);

        knight.rank = oldRank;
        knight.file = oldFile;
        b.boardArray[m.newRank][m.newFile] = false;
        b.numMoves--;
        //b.printBoard(knight);
    }

    private static void doMove(Board b, Knight knight, Move m) {
        knight.rank = m.newRank;
        knight.file = m.newFile;
        b.boardArray[knight.rank][knight.file] = true;
        b.numMoves++;
        //b.printBoard(knight);
    }

}

