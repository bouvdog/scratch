package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {

    public static int reverseIt(int x) {
        long i = x;
        boolean negative = false;
        if (i < 0) {
            negative = true;
            i = i * -1;
        }
        String s = String.valueOf(i);
        char[] cInt = s.toCharArray();
        char[] rc = new char[cInt.length];
        int index = cInt.length - 1;
        for (char c : cInt) {
            rc[index] = c;
            index--;
        }
        long result = Long.parseLong(String.valueOf(rc));

        if (negative) {
            result = result * -1;
            if (result < Integer.MIN_VALUE) {
                result = 0;
            }
        } else {
            if (result > Integer.MAX_VALUE) {
                result = 0;
            }
        }

        return (int) result;
    }
}
