package utils;

import java.math.BigInteger;

public class FactorialUtils {

    public static BigInteger fact(BigInteger number){

        if (number.equals(BigInteger.ONE)){
            return BigInteger.ONE;
        }else{
            return number.multiply(fact(number.subtract(BigInteger.ONE)));
        }
    }



}
