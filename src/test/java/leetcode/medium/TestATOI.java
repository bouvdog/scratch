package leetcode.medium;

import leetcode.problems.ATOI;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestATOI {

    @Test
    public void whenString_thenReturnInt() {

        assertEquals(1, ATOI.atoi("1"));
        assertEquals(0, ATOI.atoi("0"));
        assertEquals(11, ATOI.atoi("11"));
        assertEquals(101, ATOI.atoi("101"));
        assertEquals(1010, ATOI.atoi("1010"));
        assertEquals(1, ATOI.atoi("01"));
        assertEquals(1, ATOI.atoi("     1"));

        assertEquals(101, ATOI.atoi("+101"));

        assertEquals(-101, ATOI.atoi("-101"));

        assertEquals(4193, ATOI.atoi("4193 with words"));

        assertEquals(0, ATOI.atoi("words with 4193 with words"));

        assertEquals(Integer.MIN_VALUE, ATOI.atoi("-91283472332"));

        assertEquals(Integer.MIN_VALUE, ATOI.atoi("-6147483648"));

        assertEquals(0, ATOI.atoi("1-2"));
    }
}
