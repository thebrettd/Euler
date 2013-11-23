package main.java;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/20/12
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseWords {

    public static void main(String[] args){

        String text = "Do or do not, there is no try.";

        System.out.println(reverseString(text));

    }

    private static String reverseString(String text) {
        Stack<String> wordStack = new Stack<String>();

        for(String w: text.split(" ")){
            wordStack.push(w);
        }

        String reversed = "";
        while(!wordStack.empty()){
            reversed += wordStack.pop() + " ";
        }
        reversed = reversed.substring(0,reversed.length()-1);
        return reversed;

    }


}
