package main.java;

import utils.BigIntUtils;

import java.math.BigInteger;

public class PowerSum {

    public static BigInteger powerSum(int base, int power){
        BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
        BigInteger value = two.pow(power);
        return BigIntUtils.sumOfDigits(value);
    }
}
