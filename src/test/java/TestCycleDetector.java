import cracking.CycleDetector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCycleDetector {

    @Test
    public void testHazCycle() {
        int[] arr = {1, 2, 1, 4, 6, -1};
        assertTrue(CycleDetector.hazCycle(arr));

        int[] anotherArray = {1, 2, 4, 6, 8, 10};
        assertFalse(CycleDetector.hazCycle(anotherArray));

    }
}
