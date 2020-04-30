import leetcode.problems.PalindromeNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPalindromeNumber {

    @Test
    public void givenInteger_whenPalidrome_thenReturnTrue() {
        int i  = 121;
        assertTrue(PalindromeNumber.isPalindrome(i));

        i = -121;
        assertFalse(PalindromeNumber.isPalindrome(i));

        i = 10;
        assertFalse(PalindromeNumber.isPalindrome(i));
    }
}
