import com.sun.xml.internal.bind.v2.model.core.TypeRef;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/20/12
 * Time: 6:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearch {

    public static void main(String[] args){

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

        int target = 1;

        try{
            System.out.println("Found index: " + binarySearch(array,target));
        } catch (IllegalStateException e){
            System.out.println("Could not find value in array!");
        }
    }

    public static int binarySearch(int[] array, int target){
        return binarySearch(array,0,array.length-1,target);
    }

    private static int binarySearch( int[] array, int lower, int upper, int target){
        int midPoint = (lower + upper) / 2 + 1;
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
