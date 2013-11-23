package chess;

import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 11/21/12
 * Time: 8:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class KnightsTourTest {

    public KnightsTour kt;

    @Before
    public void setUp() {
        kt = new KnightsTour(5, 0, 0);
        kt.findKnightsTour();
    }

    public void testMovesCount(){
        assertTrue(kt.getMoves().size() == 25);
    }

    public void testNewMoveOldPosEqualOldMoveNewPos() throws Exception {

        ArrayList<Move> moves = kt.getMoves();

        System.out.println("Starting move validation");

        Move currMove;
        Move nextMove;

        //Ignore first and last moves because there is no previous or next move in those cases..
        for (int i = 1; i < moves.size() - 1; i++) {
            currMove = moves.get(i);
            nextMove = moves.get(i + 1);

            System.out.println("currMove:" + currMove);
            System.out.println("nextMove:" + nextMove);

            System.out.println("Comparing currMove.newPosition: " + currMove.newPosition + " with nextMove.oldPosition: " + nextMove.oldPosition);
            assertTrue(currMove.newPosition == nextMove.oldPosition);


        }
    }
}
