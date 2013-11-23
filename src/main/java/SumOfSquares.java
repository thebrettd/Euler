package main.java;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/27/12
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class SumOfSquares {

    /***
     * Returns the sum of all the squares of the numbers between 1 and num
     *
     * (i.e. sumOfSquares(10) = 385
     *
     * @param num
     * @return the sum of squares
     */
    public static int sumOfSquares(int num){
        int sum = 0;
        for(int i=1;i<=num;++i){
            sum += i*i;
        }
        return sum;
    }

    public static int squareOfSums(int num){
        int sum = 0;
        for (int i=1;i<=num;++i){
            sum += i;
        }
        return sum*sum;
    }

    public static void main(String[] args){
        System.out.println("Sum of squares 10: " + sumOfSquares(10));
        System.out.println("Square of sums 10: " + squareOfSums(10));
        System.out.println("Difference of sum of squares and square of sum: " + (squareOfSums(100) - sumOfSquares(100)));
    }
}
