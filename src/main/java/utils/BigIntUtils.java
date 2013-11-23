package utils;

import java.math.BigInteger;

public class BigIntUtils {

    public static BigInteger findNearestPowerOfTen(BigInteger bint){
        BigInteger divisor = BigInteger.ONE;

        int length = bint.toString().length();
        for (int i=0;i<length-1;i++){
            divisor = divisor.multiply(BigInteger.TEN);
        }

        return divisor;
    }

    public static BigInteger sumOfDigits(BigInteger bint){
        BigInteger sum = BigInteger.ZERO;

        BigInteger currDigit = null;
        do{
            BigInteger divisor = findNearestPowerOfTen(bint);

            currDigit = bint.divide(divisor);
            sum = sum.add(currDigit);
            bint = bint.mod(divisor);
        } while(currDigit.compareTo(BigInteger.ZERO) > 0);

        return sum;
    }



}
