import cracking.Overlap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOverlap {

    @Test
    public void givenTwoRectangles_thenTestForOverlap() {
        int[] twoRectangles = {2, 1, 5, 5, 3, 2, 5, 7};
        assertEquals(6, Overlap.rectangleOverlap(twoRectangles));
    }
}
