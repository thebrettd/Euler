import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/29/12
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Problem7 {

    public static void main(String[] args){
        problem7();
    }

    private static void problem7(){
        BigInteger i = new BigInteger("204729");
        HashMap<BigInteger,PossiblePrime> results = SieveOfEratosthenes.generatePrimes(i);

        int num = 1;
        for (BigInteger z = new BigInteger("2");z.compareTo(new BigInteger("" + results.size())) < 0;z=z.add(BigInteger.ONE)) {
            PossiblePrime pp = results.get(z);
            if (pp != null && pp.isPrime) {
                System.out.println(num + " " + pp.value);
                ++num;
            }

        }

    }
}
