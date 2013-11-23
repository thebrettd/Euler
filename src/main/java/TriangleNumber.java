package main.java;

public class TriangleNumber {
    public static int computeTriangleNumber(int currTriangleNumber) {
        int sum = 0;
        for (int i = 1; i <= currTriangleNumber; i++) {
            sum += i;
        }
        return sum;
    }
}