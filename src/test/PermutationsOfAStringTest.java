import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;

public class PermutationsOfAStringTest {

    @Test
    public void testPemutations(){
        ArrayList<String> perms = PermutationsOfAString.generatePermutations("fact");
        assertTrue(perms.size() == 24);
        assertTrue(perms.contains("fact"));
        assertTrue(perms.contains("tcaf"));
        assertTrue(perms.contains("fatc"));

        perms = PermutationsOfAString.generatePermutations("ab");
        assertTrue(perms.size() == 2);
        assertTrue(perms.contains("ab"));
        assertTrue(perms.contains("ba"));

        perms = PermutationsOfAString.generatePermutations("a");
        assertTrue(perms.size() == 1);
        assertTrue(perms.contains("a"));
    }
}
