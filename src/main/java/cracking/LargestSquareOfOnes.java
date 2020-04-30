package cracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestSquareOfOnes {

    public static int compute(int[][] matrix) {

        int[][] cache = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                cache[i][j] = matrix[i][j];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i > 0 && j > 0) {
                    if (matrix[i][j] > 0) {
                        cache[i][j] = 1 + Math.min(Math.min(cache[i][j - 1], cache[i - 1][j]), cache[i - 1][j - 1]);
                    }
                    if (cache[i][j] > result) {
                        result = cache[i][j];
                    }
                }
            }
        }
        return result;
    }

}
