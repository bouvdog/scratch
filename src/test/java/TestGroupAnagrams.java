import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import cracking.GroupAnagrams;
import org.junit.jupiter.api.Test;

public class TestGroupAnagrams {

    @Test
    public void testIsAnagram() {
        String one = "able";
        String two = "elba";

        assertTrue(GroupAnagrams.isAnagram(one, two));
        assertFalse(GroupAnagrams.isAnagram(one, "ella"));
    }
}
