import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/27/12
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class SieveOfEratosthenes {

    /*
    private static class PossiblePrime {
        public BigInteger value;
        public boolean isPrime;

        public PossiblePrime(BigInteger value) {
            this.value = value;
            this.isPrime = true;
        }

        public void markNotPrime() {
            this.isPrime = false;
        }
    }*/

   /*
    public void populateList(int num) {
        //Generate primes until you hit num primes found
        int lowerBound = 2;
        int upperBound = 3;
        while (primesList.size() < num) {
            //generatePrimes(lowerBound,upperBound);
            lowerBound = upperBound;
            upperBound += 10;
        }
    }*/

    /*
    */
    public static HashMap<BigInteger,PossiblePrime> generatePrimes(BigInteger upperBound) {
        HashMap<BigInteger,PossiblePrime> possiblePrimes = new HashMap<BigInteger, PossiblePrime>();

        //Create a list of consecutive integers from 2 to n: (2, 3, 4, ..., n).
        for (BigInteger i = new BigInteger("0"); i.compareTo(upperBound) <= 0; i = i.add(BigInteger.ONE)) {
            possiblePrimes.put(i, new PossiblePrime(i));
            //System.out.println("Added new possiblePrime " + i);
        }

        //Initially, let p equal 2, the first prime number.
        //Starting from p, count up in increments of p and mark each of these numbers greater than p itself in the list.
        // These numbers will be 2p, 3p, 4p, etc.; note that some of them may have already been marked. In other words, remove all multiples of p from p to n.
        BigInteger p = new BigInteger("2");
        for(BigInteger i= new BigInteger("2");i.compareTo(new BigInteger(""+possiblePrimes.size())) <= 0; i=i.add(BigInteger.ONE)){

            //System.out.println("Marking multiples of p=" + p);
            for (BigInteger j = p.multiply(p); j.compareTo(upperBound) <= 0; j = j.add(p)) {
                possiblePrimes.get(j).markNotPrime();
                //System.out.println("Marked " + j  + " as notPrime");
            }

            //Find the first number greater than p in the list that is not marked.
            // If there was no such number, stop.
            // Otherwise, let p now equal this number (which is the next prime), and repeat from step 3.
            boolean found = false;
            BigInteger k = i.add(BigInteger.ONE);
            while(k.compareTo(upperBound) < 0){
                PossiblePrime possibleNextP = possiblePrimes.get(k);
                if (possibleNextP.isPrime){
                    p = possibleNextP.value;
                    found = true;
                    break;
                }
                k = k.add(BigInteger.ONE);
            }
            if (!found)
                break;
        }


        return possiblePrimes;

    }

    public static void problem7(){
        BigInteger i = new BigInteger("204729");
        HashMap<BigInteger,PossiblePrime> results = generatePrimes(i);

        int num = 1;
        for (BigInteger z = new BigInteger("2");z.compareTo(new BigInteger("" + results.size())) < 0;z=z.add(BigInteger.ONE)) {
            PossiblePrime pp = results.get(z);
            if (pp != null && pp.isPrime) {
                System.out.println(num + " " + pp.value);
                ++num;
            }

        }

    }

    public static void main(String[] args) {
        //Is x a factor of y?
        problem3();
    }

    private static void problem10() {
        BigInteger i= new BigInteger("2000000");

        HashMap<BigInteger,PossiblePrime> results = generatePrimes(i);

        BigInteger sum = new BigInteger("0");
        for (BigInteger z = new BigInteger("2");z.compareTo(new BigInteger("" + results.size())) < 0;z=z.add(BigInteger.ONE)) {
            PossiblePrime pp = results.get(z);
            if (pp != null && pp.isPrime) {
                sum = sum.add(pp.value);
            }
        }

        System.out.println("Sum of primes below " + i + ":" + sum);

    }

    private static void problem3(){
        /*
        BigInteger i = new BigInteger("600851475143");
        HashMap<BigInteger,PossiblePrime> results = generatePrimes(i);
        System.out.println("Done generating primes up to " + i.toString());

        for(BigInteger j = new BigInteger("" + results.size());j.compareTo(BigInteger.ZERO) > 0;j = j.subtract(BigInteger.ONE)){
            PossiblePrime pp = results.get(j);
            if (pp != null && pp.isPrime){
                BigInteger possibleFactor = pp.value;
                //If i mod possiblePrime is 0, it is a factor
                if (i.mod(possibleFactor).compareTo(BigInteger.ZERO) == 0){
                    System.out.println("Found largest prime factor: " + possibleFactor.toString());
                }
            }
        }  */

        BigInteger num = new BigInteger("600851475143");

        for(BigInteger i = new BigInteger(num.toString()).subtract(BigInteger.ONE); i.compareTo(BigInteger.ONE) >= 0; i = i.subtract(BigInteger.ONE)){
            if (isFactor(i,num)){
                System.out.println("Testing factor " + i + " for primality");
                if(isPrime(i)){
                    System.out.println("Largest prime factor" + i);
                    break;
                }
            }
        }
    }


    private static boolean isPrime(BigInteger i) {
        for (BigInteger j = i.subtract(BigInteger.ONE); j.compareTo(BigInteger.ONE) > 0; j = j.subtract(BigInteger.ONE)){
            if (isFactor(j,i)){
                return false;
            }
        }
        return true;
    }

    //Is x a factor of y?
    private static boolean isFactor(BigInteger i, BigInteger num) {
        return num.mod(i).compareTo(BigInteger.ZERO) == 0;
    }

}
