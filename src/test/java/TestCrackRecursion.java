import static org.junit.jupiter.api.Assertions.assertEquals;

import cracking.Steps;
import org.junit.jupiter.api.Test;

public class TestCrackRecursion {
    @Test
    public void testThreeSteps() {
        Steps s = new Steps();
        s.lastStep(3);
        assertEquals(4, s.permutations);
    }

    @Test
    public void testTwoSteps() {
        Steps s = new Steps();
        s.lastStep(2);
        assertEquals(3, s.permutations);
    }

    @Test
    public void testOneSteps() {
        Steps s = new Steps();
        s.lastStep(1);
        assertEquals(1, s.permutations);
    }
}
