package utils.search;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class BinarySearchTest {

    @Test
    public void testBinarySearch(){

        int[] array = new int[10];

        array[0] = 5;
        array[1] = 13;
        array[2] = 45;
        array[3] = 125;
        array[4] = 2356;
        array[5] = 38865;
        array[6] = 245642;
        array[7] = 375347;
        array[8] = 6976979;
        array[9] = 7898989;

        int foundIndex;
        for (int i=0;i<array.length;i++){
            System.out.print("Searching for target: " + array[i]);
            foundIndex = BinarySearch.binarySearch(array,array[i]);
            System.out.println(" | Found target at position: " + foundIndex);
            assertTrue(foundIndex == i);
        }
    }

}
