import leetcode.recursion.PrincipleOfRecursion;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestPORecursion {

    @Test
    public void givenString_thenReverseIt() {
        PrincipleOfRecursion por = new PrincipleOfRecursion();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        por.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
