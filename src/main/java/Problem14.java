package main.java;

import java.util.ArrayList;

public class Problem14 {

    public static void main(String[] args){

        int currLongestChainValue = 0;
        int currLongestChainLength = 0;
        for (int i=1; i<200000;i++){
            ArrayList<Integer> seq = CollatzSequence.generateCollatzSequence(i);
            System.out.println("Computed sequence: " + i);

            if (seq.size() > currLongestChainLength){
                currLongestChainValue = i;
                currLongestChainLength = seq.size();
            }
        }

        System.out.println("LongestChainValue: " + currLongestChainValue);

    }


}
