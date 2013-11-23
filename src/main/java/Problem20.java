package main.java;

import utils.BigIntUtils;
import utils.FactorialUtils;

import java.math.BigInteger;

public class Problem20 {

    public static void main(String[] args){

        BigInteger fact = FactorialUtils.fact(new BigInteger("100"));
        System.out.println("Calculating sum of digits: " + fact);
        BigInteger sum = BigIntUtils.sumOfDigits(fact);
        System.out.println("Sum of digits: "+ sum);

    }



}


