import org.junit.Test;

import java.util.ArrayList;

public class CollatzSequenceTest {

    @Test
    public void testCollatzGenerator(){
        testSequence13();
    }

    //13  40  20  10  5  16  8  4  2  1
    private void testSequence13() {
        String answerStr = "13 40 20 10 5 16 8 4 2 1";
        String[] split = answerStr.split(" ");

        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            answer.add(i,Integer.parseInt(split[i]));
        }

        ArrayList<Integer> seq = CollatzSequence.generateCollatzSequence(13);
        assert (seq.size() == 10);

        for (int i=0;i<answer.size();i++){
            assert (seq.get(i).equals(answer.get(i)));
        }
    }


}
