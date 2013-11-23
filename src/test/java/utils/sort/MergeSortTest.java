package utils.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class MergeSortTest {

    @Test
    public void testMergeSort() throws Exception {
        List<Integer> input = new ArrayList<Integer>();
        input.add(5);
        input.add(1);
        input.add(6);
        input.add(7);
        input.add(3);
        input.add(9);

        List<Integer> sortedList = MergeSort.mergeSort(input);
        assertTrue(MergeSort.isSorted(sortedList));

        sortedList = new ArrayList<Integer>();
        Random r = new Random();
        for(int i=0;i<10000000;i++){
            input.add(r.nextInt());
        }
        long startTime = System.nanoTime();


        sortedList = MergeSort.mergeSort(input);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        assertTrue(MergeSort.isSorted(sortedList));

    }

    @Test
    public void testMerge() throws Exception {

        List<Integer> inputListOne = new ArrayList<Integer>();
        inputListOne.add(1);
        inputListOne.add(2);
        inputListOne.add(3);
        inputListOne.add(4);

        List<Integer> inputListTwo = new ArrayList<Integer>();
        inputListTwo.add(5);
        inputListTwo.add(6);
        inputListTwo.add(7);
        inputListTwo.add(8);

        List<Integer> sortedList = MergeSort.merge(inputListOne, inputListTwo);

        assertTrue(MergeSort.isSorted(sortedList));

        inputListOne.clear();
        inputListOne.add(4);
        inputListOne.add(7);
        inputListOne.add(9);
        inputListOne.add(11);

        inputListTwo.clear();
        inputListTwo.add(5);
        inputListTwo.add(6);
        inputListTwo.add(7);
        inputListTwo.add(8);
        sortedList = MergeSort.merge(inputListOne, inputListTwo);
        assertTrue(MergeSort.isSorted(sortedList));

        inputListOne.clear();
        inputListOne.add(4);

        inputListTwo.clear();
        inputListTwo.add(5);
        inputListTwo.add(6);
        inputListTwo.add(7);
        inputListTwo.add(8);
        sortedList = MergeSort.merge(inputListOne, inputListTwo);
        assertTrue(MergeSort.isSorted(sortedList));



    }




}
