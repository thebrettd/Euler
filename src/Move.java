/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 11/19/12
 * Time: 3:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Move {
    int oldRank;
    int oldFile;

    int newRank;
    int newFile;

    public Move(int oldRank, int oldFile, int newRank, int newFile) {
        this.oldRank = oldRank;
        this.oldFile = oldFile;

        this.newRank = newRank;
        this.newFile = newFile;
    }
}