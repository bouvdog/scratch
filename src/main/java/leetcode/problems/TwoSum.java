package leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> values = new HashMap<>();
        int[] terms = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int numToBeFound = target - nums[i];
            if (values.containsKey(numToBeFound)) {
                terms[0] = values.get(numToBeFound);
                terms[1] = i;
                break;
            }
            values.put(nums[i], i);
        }
        return terms;
    }

}
