import leetcode.problems.TwoSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTwoSum {

    @Test
    public void testTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int[] foobar = TwoSum.twoSum(nums, 9);
        assertTrue(foobar[0] == 0);
        assertTrue(foobar[1] == 1);

        int[] moreNums = {3, 2, 4};
        foobar = TwoSum.twoSum(moreNums, 6);
        assertTrue(foobar[0] == 1);
        assertTrue(foobar[1] == 2);
    }
}
