/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 11/19/12
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Board {

    private Boolean[][] boardArray;

    private int numRanks;
    private int numFiles;
    private int numMoves;

    public Board(int numRanks, int numFiles) {
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

    public void incrementMoves(){
        this.numMoves++;
    }

    public void decrementMoves(){
        this.numMoves--;
    }

    public int getNumMoves() {
        return numMoves;
    }

    public Boolean[][] getBoardArray() {
        return boardArray;
    }

    public int getNumRanks() {
        return numRanks;
    }

    public int getNumFiles() {
        return numFiles;
    }

}
