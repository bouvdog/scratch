package leetcode.medium;

import leetcode.problems.WaterCatcher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWaterCatcher {

    @Test
    public void givenStructure_thenReturnVolumeCaught() {
        int[] struct = {1, 0, 1};
        assertEquals(1, WaterCatcher.volumneOfWater(struct));

        int[] struct1 = {0, 0, 0};
        assertEquals(0, WaterCatcher.volumneOfWater(struct1));

        int[] struct2= {1, 1, 1};
        assertEquals(0, WaterCatcher.volumneOfWater(struct2));

        int[] struct3= {2, 0, 2};
        assertEquals(2, WaterCatcher.volumneOfWater(struct3));

        int[] struct4= {2, 0, 4};
        assertEquals(2, WaterCatcher.volumneOfWater(struct4));

        int[] struct5= {4, 0, 2};
        assertEquals(2, WaterCatcher.volumneOfWater(struct5));
    }
}
