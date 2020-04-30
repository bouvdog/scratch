import leetcode.problems.LongestSubstringNoRepeats;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLongestNoRepeats {

    @Test
    public void givenStringWithRepeatingChars_returnNoRepeats() {
        String a = "abcabcbb";
        String b = "bbbbb";
        String c = "pwwkew";

        assertEquals(3, LongestSubstringNoRepeats.lengthOfLongestSubstring(a));
        assertEquals(1, LongestSubstringNoRepeats.lengthOfLongestSubstring(b));
        assertEquals(3, LongestSubstringNoRepeats.lengthOfLongestSubstring(c));
        assertEquals(0, LongestSubstringNoRepeats.lengthOfLongestSubstring(""));
        assertEquals(1, LongestSubstringNoRepeats.lengthOfLongestSubstring(" "));

    }
}
