import java.util.ArrayList;
import java.util.HashMap;

public class CollatzSequence {

    private static HashMap<Integer, ArrayList<Integer>> collatzSequences = new HashMap<Integer, ArrayList<Integer>>();

    public static ArrayList<Integer> generateCollatzSequence(int i) {
        ArrayList<Integer> seq = new ArrayList<Integer>();
        seq.add(i);

        collatzSequenceHelper(i,seq);

        collatzSequences.put(i,seq);

        return seq;
    }

    private static void collatzSequenceHelper(int i, ArrayList<Integer> seq) {
        if (i==1){
            return;
        }
        else if (i % 2 == 0){
            int newNum = i / 2;
            recurseOrLookup(seq,newNum);
        }else{
            int newNum = 3 * i + 1;
            recurseOrLookup(seq,newNum);
        }
    }

    private static void recurseOrLookup(ArrayList<Integer> seq, int newNum) {
        seq.add(newNum);
        if (collatzSequences.containsKey(newNum)){
            seq.addAll(collatzSequences.get(newNum));
        }
        else{
            collatzSequenceHelper(newNum,seq);
        }
    }


}