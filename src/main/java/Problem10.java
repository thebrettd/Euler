package main.java;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/29/12
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem10 {

    public static void main(String[] args){
        problem10();
    }

    private static void problem10() {
        BigInteger i= new BigInteger("2000000");

        HashMap<BigInteger,PossiblePrime> results = SieveOfEratosthenes.generatePrimes(i);

        BigInteger sum = new BigInteger("0");
        for (BigInteger z = new BigInteger("2");z.compareTo(new BigInteger("" + results.size())) < 0;z=z.add(BigInteger.ONE)) {
            PossiblePrime pp = results.get(z);
            if (pp != null && pp.isPrime) {
                sum = sum.add(pp.value);
            }
        }

        System.out.println("Sum of primes below " + i + ":" + sum);

    }
}
