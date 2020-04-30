import cracking.LargestSquareOfOnes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLargestSquareOfOnes {

    @Test
    public void testFindLargeSquareOfOnes() {
        int[][] matrix = new int[4][5];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[0][2] = 0;
        matrix[0][3] = 1;
        matrix[0][4] = 0;

        matrix[1][0] = 0;
        matrix[1][1] = 1;
        matrix[1][2] = 1;
        matrix[1][3] = 1;
        matrix[1][4] = 0;
        matrix[2][0] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 1;
        matrix[2][3] = 1;
        matrix[2][4] = 0;
        matrix[3][0] = 0;
        matrix[3][1] = 1;
        matrix[3][2] = 1;
        matrix[3][3] = 1;
        matrix[3][4] = 1;

        int size = LargestSquareOfOnes.compute(matrix);
        assertEquals(3, size);
    }
}
