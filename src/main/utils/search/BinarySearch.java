package utils.search;

import com.sun.xml.internal.bind.v2.model.core.TypeRef;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/20/12
 * Time: 6:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int target){
        return binarySearch(array,0,array.length-1,target);
    }

    /***
     *
     * @param array The array you are searching through
     * @param lower The index of the lower starting position
     * @param upper The index of upper starting position
     * @param target the value you are searching for
     * @return the index of target in array
     */
    private static int binarySearch( int[] array, int lower, int upper, int target){
        int length = (upper - lower + 1);
        int midPoint = (length / 2) + lower;
        int currVal = array[midPoint];

        if (currVal == target)
            return midPoint;
        else if (lower == upper){
            throw new IllegalStateException();
        }
        else if (currVal > target)
            return binarySearch(array,lower, midPoint-1,target);
        else
            return binarySearch(array,midPoint+1,upper,target);


    }

}
