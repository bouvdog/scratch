package leetcode.easy;

import leetcode.problems.RemoveDupsFromSorted;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRemoveDupsFromSorted {

    @Test
    public void givenSortedArrayWithDups_thenReturnArrayWithoutDups() {
        int[] tester = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assertEquals(5, RemoveDupsFromSorted.removeDuplicates(tester));
    }

}
