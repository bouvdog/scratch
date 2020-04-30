package algodesign;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {

    public static List<String> printTheSubsets(int[] array) {
        int numOfSubsets = (int)Math.pow(array.length,2) - 1;
        List<String> subsets = new ArrayList<>();
        StringBuffer subset = new StringBuffer();
        // Each bit position is the index of the array from which we draw the the subsets
        for (int i=0; i < numOfSubsets; i++) {

            // zero is a special case; we may include the empty set as a subset; interviewer question
            if (i==0){
                continue;
            }

            List<Integer> positions = bitPositions(i);
            for (Integer e : positions) {
                subset.append(array[e-1] + " ");
            }
            subsets.add(subset.toString());
            subset.setLength(0);
        }
        return subsets;
    }

    static List<Integer> bitPositions(int number) {
        List<Integer> positions = new ArrayList<>();
        int position = 1;
        while (number != 0) {
            if ((number & 1) != 0) {
                positions.add(position);
            }
            position++;
            number = number >>> 1;
        }
        return positions;
    }
}
