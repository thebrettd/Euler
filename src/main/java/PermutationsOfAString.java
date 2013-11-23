package main.java;

import java.util.ArrayList;

public class PermutationsOfAString{

    public static void main(String[] args){

        String input = "fact";

        ArrayList<String> permutations = generatePermutations(input);

        for(String perm : permutations){
            System.out.println(perm);
        }
    }

    public static ArrayList<String> generatePermutations(String input) {
        return permute("", input, new ArrayList<String>());
    }

    /***
     * Recursive algorithm for generating the permutations of a string.
     *
     * The permutations of a string can be found by taking the first character and appending all of the substrings which
     * are permutations of the remaining characters.
     *
     * Base case - A string, and an empty list of other characters to permute
     * Add the string to the list.
     *
     * Non base - A string, and a nonempty list of characters to permute
     * For each character in the string, find permutations of that character followed by all the remaining characters.
     *
     * @param currString a string of characters that have already been permuted
     * @param charactersToPermute The characters which still need to be permuted.
     * @param permutations The collection of permutations that you are constructing
     * @return the collection of permutations
     */
    private static ArrayList<String> permute(String currString, String charactersToPermute, ArrayList<String> permutations){

        if (charactersToPermute.length() == 0)
            permutations.add(currString);
        else{

            for (int i=0;i<charactersToPermute.length();++i){
                String newRemainingChars = removeCharacterAtIndex(i,charactersToPermute);
                permute(currString + charactersToPermute.charAt(i), newRemainingChars, permutations);
            }
        }
        return permutations;
    }

    /***
     * Remove the ith character from a string
     * @param i the character to remove
     * @param charactersToPermute the String of characters
     * @return charactersToPermute with the
     */
    private static String removeCharacterAtIndex(int i, String charactersToPermute) {
        String remainingCharacters = "";
        for (int j=0;j<charactersToPermute.length();++j){
            if (j != i)
                remainingCharacters += charactersToPermute.charAt(j);
        }
        return remainingCharacters;
    }


}
