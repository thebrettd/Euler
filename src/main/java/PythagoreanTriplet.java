package main.java;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/28/12
 * Time: 6:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class PythagoreanTriplet {

    public static int prodOfTriplet(){

        for(int a=1;a<1000;a++){
            for(int b=2;b<1000;b++){
                for(int c=3;c<1000;c++){
                    if (isTriplet(a,b,c) && (a+b+c == 1000)){
                        return a*b*c;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isTriplet(int a, int b, int c) {
        //System.out.println("Trying triplet :" + a + " " + b + " " + c);
        return a * a + b * b == c * c;
    }

    public static void main(String[] args){


        System.out.println("a*b*c where a,b,c form a triplet whose sum is 1000: " + prodOfTriplet());
    }
}
