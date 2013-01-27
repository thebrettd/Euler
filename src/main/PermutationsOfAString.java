import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: brett
 * Date: 10/20/12
 * Time: 7:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class PermutationsOfAString{

    public static void main(String[] args){

        String input = "fact";

        generatePermutations(input);

    }

    private static void generatePermutations(String input) {
        permute("", input);

    }

    private static void permute(String currString, String charactersToPermute){
        if (charactersToPermute.length() == 0)
            System.out.println(currString);
        else{
            for (int i=0;i<charactersToPermute.length();++i){
                String newRemainingChars = removeCharacterAtIndex(i,charactersToPermute);
                permute(currString + charactersToPermute.charAt(i), newRemainingChars);
            }
        }
    }

    private static String removeCharacterAtIndex(int i, String charactersToPermute) {
        String remainingCharacters = "";
        for (int j=0;j<charactersToPermute.length();++j){
            if (j != i)
                remainingCharacters += charactersToPermute.charAt(j);
        }
        return remainingCharacters;
    }


}
