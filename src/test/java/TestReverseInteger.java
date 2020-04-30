import leetcode.problems.ReverseInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReverseInteger {

    @Test
    public void whenInt_thenReturnItsReverse() {
        int i = 123;
        int r = ReverseInteger.reverseIt(i);
        assertEquals(321, r);

        i = 0;
        r = ReverseInteger.reverseIt(i);
        assertEquals(0, r);

        i = -123;
        r = ReverseInteger.reverseIt(i);
        assertEquals(-321, r);

        i = 120;
        r = ReverseInteger.reverseIt(i);
        assertEquals(21, r);

        // 2^31-1 = 2147483647
        i = Integer.MAX_VALUE;
        r = ReverseInteger.reverseIt(i);
        assertEquals(0, r);

        i = Integer.MIN_VALUE;
        r = ReverseInteger.reverseIt(i);
        assertEquals(0, r);
    }
}
