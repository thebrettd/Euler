import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class Problem12 {

    private static HashMap<BigInteger, PossiblePrime> primesList = SieveOfEratosthenes.generatePrimes(new BigInteger("2000000"));

    public static void main(String[] args){

        int currTriangleNumber = 1;
        int numDivisors = 0;
        int triangleValue = 0;
        do{
            numDivisors = 0;
            currTriangleNumber++;
            triangleValue = TriangleNumber.computeTriangleNumber(currTriangleNumber);
            //System.out.println(currTriangleNumber + ": " + triangleValue);

            numDivisors = calculateNumDivisorsPrimeFactorization(triangleValue);

        }while(numDivisors <= 500);

        System.out.println("The first triangle number with > 500 divisors: " + triangleValue);

    }

    /**
     * Calculate number of divisors using prime factorization
     * http://mathcentral.uregina.ca/QQ/database/QQ.02.06/joe1.html
     * @param triangleValue
     * @return
     */
    private static int calculateNumDivisorsPrimeFactorization(int triangleValue) {
        BigInteger num = new BigInteger(Integer.toString(triangleValue));

        System.out.println("Calculating primeFactors for " + triangleValue);
        ArrayList<BigInteger> primeFactors = new  ArrayList<BigInteger>();
        PrimeFactors.factorize(num, primeFactors, primesList);

        HashMap<BigInteger, Integer> factorsCount = new HashMap<BigInteger,Integer>();

        //loop over the primeFactors, counting the number of times each prime factor occurs in the list.
        for (BigInteger primeFactor : primeFactors) {
            if (factorsCount.containsKey(primeFactor)){
                Integer oldCount = factorsCount.get(primeFactor);
                factorsCount.put(primeFactor,oldCount + 1);
            }else{
                factorsCount.put(primeFactor,2);
            }
        }

        int numFactors = 1;
        for (Integer factorCount : factorsCount.values()){
            numFactors *= factorCount;
        }

        return numFactors;

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
