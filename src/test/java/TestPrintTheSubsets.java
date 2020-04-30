import org.junit.jupiter.api.Test;

import java.util.List;

import algodesign.Subsets;

public class TestPrintTheSubsets {

    @Test
    public void givenSetOfIntegers_thenReturnStringSubsets() {
        int[] i = {5, 6, 7};

        List<String> s = Subsets.printTheSubsets(i);
        s.stream().forEach(System.out::println);
    }
}
