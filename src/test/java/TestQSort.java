import cracking.QSort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestQSort {

    @Test
    public void testQuicksort() {
        Integer[] nums = {5, 2, 7, 4, 9, 8, 10, 3, 6};
        QSort.youTubeQSort(nums, 0, nums.length-1);
        assertEquals(2, nums[0]);
        assertEquals(10, nums[nums.length - 1]);
    }

    @Test
    public void testYTPartion() {
        Integer[] nums = {5, 2, 7, 4, 9, 8, 10, 3, 6};
        Integer[] expected = {5, 2, 7, 4, 6, 8, 3, 9, 10};
        QSort.youTubePartition(nums, 0, nums.length-1);
        assertEquals(3, nums[6]);
        assertEquals(9, nums[7]);
    }

    @Test
    public void testYTPartionAfterOnePass() {
        Integer[] nums = {5, 2, 7, 4, 9, 8, 3, 9, 10};
        Integer[] expected = {5, 2, 7, 4, 6, 8, 3, 9, 10};
        QSort.youTubePartition(nums, 0, 6);
        assertEquals(3, nums[6]);
        assertEquals(9, nums[7]);
    }
}
