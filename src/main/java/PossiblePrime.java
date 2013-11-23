import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/29/12
 * Time: 3:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class PossiblePrime {

        public BigInteger value;
        public boolean isPrime;

        public PossiblePrime(BigInteger value) {
            this.value = value;
            this.isPrime = true;
        }

        public void markNotPrime() {
            this.isPrime = false;
        }

}
