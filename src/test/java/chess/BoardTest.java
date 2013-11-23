package chess;


import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 11/21/12
 * Time: 6:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class BoardTest{

    public void testHasBeenVisited() throws Exception {
        Board b = new Board(7,7);
        b.getBoardArray()[1][1] = true;

        ChessCoordinate testCoord = new ChessCoordinate(1,1);
        assertTrue(b.hasBeenVisited(testCoord));

    }

    public void testPrintBoard() throws Exception {

    }

    public void testIncrementMoves() throws Exception {

    }

    public void testDecrementMoves() throws Exception {

    }

    public void testGetNumMoves() throws Exception {

    }

    public void testGetBoardArray() throws Exception {

    }

    public void testGetNumRanks() throws Exception {

    }

    public void testGetNumFiles() throws Exception {

    }
}
