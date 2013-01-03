import java.util.ArrayList;

public class CollatzSequence {

    public static ArrayList<Integer> generateCollatzSequence(int i) {
        ArrayList<Integer> seq = new ArrayList<Integer>();
        seq.add(i);
        collatzSequenceHelper(i,seq);
        return seq;
    }

    private static void collatzSequenceHelper(int i, ArrayList<Integer> seq) {
        if (i==1){
            return;
        }
        else if (i % 2 == 0){
            int newNum = i / 2;
            seq.add(newNum);
            collatzSequenceHelper(newNum,seq);
        }else{
            int newNum = 3 * i + 1;
            seq.add(newNum);
            collatzSequenceHelper(newNum,seq);
        }
    }


}