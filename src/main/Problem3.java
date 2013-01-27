import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/29/12
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem3 {

    /**
     * Generate all the primes up to the number.
     * Bad - primes hashmap grows too big
     */
    private static void try1(BigInteger i) {

        HashMap<BigInteger, PossiblePrime> results = SieveOfEratosthenes.generatePrimes(i);
        System.out.println("Done generating primes up to " + i.toString());

        for (BigInteger j = new BigInteger("" + results.size()); j.compareTo(BigInteger.ZERO) > 0; j = j.subtract(BigInteger.ONE)) {
            PossiblePrime pp = results.get(j);
            if (pp != null && pp.isPrime) {
                BigInteger possibleFactor = pp.value;
                //If i mod possiblePrime is 0, it is a factor
                if (i.mod(possibleFactor).compareTo(BigInteger.ZERO) == 0) {
                    System.out.println("Found largest prime factor: " + possibleFactor.toString());
                }
            }
        }
    }

    /**
     * Loop backwards from n-1 and determine if it is a factor, if so, determine if it is prime
     * Takes too long to determine is BigInteger is prime with naive division
     */
    private static void try2(BigInteger num) {

        for (BigInteger i = new BigInteger(num.toString()).subtract(BigInteger.ONE); i.compareTo(BigInteger.ONE) >= 0; i = i.subtract(BigInteger.ONE)) {
            if (isFactor(i, num)) {
                System.out.println("Testing factor " + i + " for primality");
                if (isPrime(i)) {
                    System.out.println("Largest prime factor" + i);
                    break;
                }
            }
        }
    }

    private static boolean isPrime(BigInteger i) {
        for (BigInteger j = i.subtract(BigInteger.ONE); j.compareTo(BigInteger.ONE) > 0; j = j.subtract(BigInteger.ONE)) {
            if (isFactor(j, i)) {
                return false;
            }
        }
        return true;
    }

    //Is x a factor of y?
    private static boolean isFactor(BigInteger i, BigInteger num) {
        return num.mod(i).compareTo(BigInteger.ZERO) == 0;
    }

    public static void main(String[] args) {
        problem3();
    }

    private static void problem3() {
        BigInteger num = new BigInteger("600851475143");

        HashMap<BigInteger, PossiblePrime> primesList = SieveOfEratosthenes.generatePrimes(new BigInteger("2000000"));
        System.out.println("Generated list of all primes <= 2000000");

        ArrayList<BigInteger> primeFactors = new  ArrayList<BigInteger>();
        System.out.println("Size of primeFactors: " + primeFactors.size());

        PrimeFactors.factorize(num, primeFactors, primesList);

        for (BigInteger primeFactor : primeFactors) {
            System.out.println("Prime factors: " + primeFactor);
        }
    }


}
