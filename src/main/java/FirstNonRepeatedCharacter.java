package main.java;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/20/12
 * Time: 10:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class FirstNonRepeatedCharacter {

    public static void main(String[] args){

        char[] str1 = "total".toCharArray();
        char[] str2 = "teeter".toCharArray();

        findFirstNonRepeatedIterative(str1);
        findFirstNonRepeatedIterative(str2);

        findFirstNonRepeatedSmarter(str1);
        findFirstNonRepeatedSmarter(str2);
    }

    private static void findFirstNonRepeatedSmarter(char[] str1) {
        HashMap<Character,Integer> countMap = new HashMap<Character, Integer>();

        for (char c : str1) {
            if (countMap.containsKey(c)){
                countMap.put(c, countMap.get(c) + 1);
            }else{
                countMap.put(c,1);
            }
        }

        boolean found = false;
        for (char c: str1 ){
            if (countMap.get(c) == 1){
                System.out.println("Found non-repeating char: " + c);
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Could not find non-repeating char");
        }
    }

    private static void findFirstNonRepeatedIterative(char[] string) {
        char currChar;
        boolean found = false;
        for (int i=0;i<string.length;i++){
            currChar = string[i];

            if (!isPresentInSubstring(currChar,i,string)){
                System.out.println("Found non-repeating char " + currChar);
                found = true;
                break;
            }
        }

        if (!found){
            System.out.println("Could not find non-repeating char in string");
        }

    }

    private static boolean isPresentInSubstring(char currChar, int i, char[] string) {
        char[] subString = new char[string.length -i];
        //todo: create substring here. Exploding complexity, pointless to implement since hashmap method works better
        for (int j=i+1;j<string.length;j++){
            if (string[j] == currChar)
                    return true;
        }
        return false;
    }




}
