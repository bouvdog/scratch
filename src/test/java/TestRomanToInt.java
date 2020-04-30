import leetcode.problems.RomanToInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRomanToInt {

    @Test
    public void givenRoman_whenSubmitted_thenReturnDecimal() {
        assertEquals(3, RomanToInt.romanToInt("III"));

        assertEquals(4, RomanToInt.romanToInt("IV"));

        assertEquals(9, RomanToInt.romanToInt("IX"));

        assertEquals(11, RomanToInt.romanToInt("XI"));

        assertEquals(58, RomanToInt.romanToInt("LVIII"));

        assertEquals(40, RomanToInt.romanToInt("XL"));

        assertEquals(1994, RomanToInt.romanToInt("MCMXCIV"));

        assertEquals(621, RomanToInt.romanToInt("DCXXI"));
    }

}
