import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class PrimeFactors {
    /**
     * Recursive algorithm described on http://www.mathsisfun.com/prime-factorization.html
     * Divide currNum by successive primes until you find a factor.
     * Add that currNum to the list of primes factors, then recurse using quotient of currNum and the factor as currNum
     *
     * @param num
     * @param primeFactors
     * @param allPrimesList
     */
    static void factorize(BigInteger num, ArrayList<BigInteger> primeFactors, HashMap<BigInteger, PossiblePrime> allPrimesList) {
        //Lookup the current number in the list of primes.
        PossiblePrime currPossiblePrime = allPrimesList.get(num);
        if (currPossiblePrime != null && currPossiblePrime.isPrime) {
            //Current number is prime, so we are done. Add the number to the list of primeFactors and stop
            primeFactors.add(currPossiblePrime.value);
            //System.out.println(currPossiblePrime.value + " is prime, adding to list of prime factors.\nDone!");
        } else {
            //currPrime = all the primes [2...infinity]
            for (BigInteger i = new BigInteger("2"); i.compareTo(new BigInteger("" + allPrimesList.size())) <= 0; i = i.add(BigInteger.ONE)) {
                currPossiblePrime = allPrimesList.get(i);
                if (currPossiblePrime != null && currPossiblePrime.isPrime) {  //allPrimesList is a hashmap containing POSSIBLE primes, so make sure it is prime first
                    if (num.mod(currPossiblePrime.value).compareTo(BigInteger.ZERO) == 0) {
                        primeFactors.add(currPossiblePrime.value);
                        //System.out.println(num + " % " + currPossiblePrime.value + " = 0, adding " + currPossiblePrime.value +  " to list of prime factors");
                        factorize(num.divide(currPossiblePrime.value), primeFactors, allPrimesList);
                        break;
                    }
                }
            }
        }
    }
}