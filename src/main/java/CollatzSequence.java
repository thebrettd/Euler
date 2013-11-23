package main.java;

import java.util.ArrayList;
import java.util.HashMap;

public class CollatzSequence {

    private static HashMap<Integer, ArrayList<Integer>> collatzSequences = new HashMap<Integer, ArrayList<Integer>>();

    //Generate the ith collatz sequence and place it in collatzSequences(i)
    public static ArrayList<Integer> generateCollatzSequence(int i) {

        ArrayList<Integer> seq = new ArrayList<Integer>();
        seq.add(i);

        collatzSequenceHelperRecursive(i,seq);
        //collatzSequenceHelperIterative(i,seq);

        //collatzSequences.put(i,seq);

        return seq;
    }

    private static void collatzSequenceHelperIterative(int i, ArrayList<Integer> seq) {

        while(i != 1){
            if (i % 2 == 0){
                seq.add(i);
                i = i/2;
            }else{
                seq.add(i);
                i = 3 * i + 1;
            }

        }
        //i == 1
        seq.add(i);

    }

    //
    private static void collatzSequenceHelperRecursive(int i, ArrayList<Integer> seq) {
        int newNum;

        if (i==1){
            return;
        }
        else if (i % 2 == 0){
            newNum = i / 2;
        }else{
            newNum = 3 * i + 1;
        }

        seq.add(newNum);

        recurseOrLookup(seq,newNum);
        //collatzSequenceHelper(newNum,seq);
    }


    private static void recurseOrLookup(ArrayList<Integer> seq, int newNum) {
        if (collatzSequences.containsKey(newNum)){
            seq.addAll(collatzSequences.get(newNum));
        }
        else{
            collatzSequenceHelperRecursive(newNum, seq);
        }
    }


}