public class Problem12 {

    public static void main(String[] args){

        int currTriangleNumber = 1;
        int numDivisors = 0;
        int triangleValue = 0;
        do{
            numDivisors = 0;
            currTriangleNumber++;
            triangleValue = TriangleNumber.computeTriangleNumber(currTriangleNumber);
            //System.out.println(currTriangleNumber + ": " + triangleValue);

            numDivisors = calculateNumDivisorsSlow(triangleValue);

        }while(numDivisors <= 500);

        System.out.println("The first triangle number with > 500 divisors: " + triangleValue);

    }

    /**
     * Naive implementation takes too long
     *
     * @param triangleValue
     * @return
     */
    private static int calculateNumDivisorsSlow(int triangleValue) {
        int numDivisors = 1;
        for (int i=2;i<=triangleValue;i++){
            if(triangleValue % i == 0){
                numDivisors++;
            }
        }

        //System.out.println("Found " + numDivisors + " for triangleValue = " + triangleValue);
        return numDivisors;
    }



}
