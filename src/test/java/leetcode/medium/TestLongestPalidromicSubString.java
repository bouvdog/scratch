package leetcode.medium;

import leetcode.problems.LongestPalidromicSubString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLongestPalidromicSubString {

    @Test
    public void givenStringNotPalidrome_thenReturnEmptyString() {
        String s = "foobar";

        assertEquals("oo", LongestPalidromicSubString.longestPalindrome(s));
    }

    @Test
    public void givenStringThatIsAPalindrome_thenReturnString() {
        String s = "babab";
        String r = LongestPalidromicSubString.longestPalindrome(s);
        assertEquals(s, LongestPalidromicSubString.longestPalindrome(s));
    }

    @Test
    public void givenStringThatStartsWithAPalindromeSubstring_thenReturnSubString() {
        assertEquals("aba", LongestPalidromicSubString.longestPalindrome("babad"));
    }

    @Test
    public void givenStringThatContainsPalindromicSubstring_thenReturnSubString() {
        assertEquals("ded", LongestPalidromicSubString.longestPalindrome("zcdedf"));
        assertEquals("dd", LongestPalidromicSubString.longestPalindrome("cddz"));
    }
}
