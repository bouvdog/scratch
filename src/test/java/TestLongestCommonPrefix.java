import leetcode.problems.LongestCommonPrefix;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLongestCommonPrefix {

    @Test
    public void givenArrayOfStrings_thenReturnLongestPrefixCommonToAll() {
        String[] words = new String[3];

        words[0] = "flower";
        words[1] = "flow";
        words[2] = "flight";

        assertEquals("fl", LongestCommonPrefix.longestCommonPrefix(words));

        words[0] = "dogs";
        words[1] ="racecar";
        words[2] = "car";

        assertEquals("", LongestCommonPrefix.longestCommonPrefix(words));


    }
}
