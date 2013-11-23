package main.java;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/20/12
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveSpecifiedCharacters {

    public static void main(String[] args){

        String text = "Battle of the Vowels: Hawaii vs. Grozny";
        String charsToRemove = "aeiou";

        String output = removeChars(text,charsToRemove);

        System.out.println(output);

    }

    public static String removeChars(String text, String charsToRemove) {
        String finalString = "";

        HashMap<Character,Boolean> removeMap = new HashMap<Character, Boolean>();
        for(int i=0;i<charsToRemove.length();++i){
            removeMap.put(charsToRemove.charAt(i),Boolean.TRUE);
        }

        char currChar;
        for(int i=0;i<text.length();i++){
            currChar = text.charAt(i);

            if (removeMap.containsKey(currChar)){
                //Do not append the char to the finalString
            } else {
                finalString += currChar;
            }

        }

        return finalString;
    }
}
