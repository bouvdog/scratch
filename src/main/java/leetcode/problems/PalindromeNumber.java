package leetcode.problems;

public class PalindromeNumber {

    public static boolean isPalindrome(int i) {
        if (i < 0) {
            return false;
        }

        String s = String.valueOf(i);
        char[] cInt = s.toCharArray();
        char[] rc = new char[cInt.length];
        int index = cInt.length - 1;
        for (char c : cInt) {
            rc[index] = c;
            index--;
        }
        String r = String.valueOf(rc);

        return s.equals(r);
    }
}
