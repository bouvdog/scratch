package leetcode.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class LongestPalidromicSubString {

    public static String longestPalindrome(String s) {
        TreeMap<Integer, String> palindromes = new TreeMap<>(Collections.reverseOrder());

        int index = 0;
        String substring = "";
        // for each char
        while (index < s.length()) {
            int left = index;
            int right = index;
            searchForPalindromes(s, left, right, palindromes);
            searchForPalindromes(s, left, right+1, palindromes);

            index++;
        }

        if (palindromes.size() > 0) {
            return palindromes.get(palindromes.firstKey());
        } else {
            return "";
        }

    }

    private static void searchForPalindromes(String s, int left, int right, TreeMap<Integer,String> palindromes) {
        // expand on either side of the char
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                if (right == s.length() - 1) {
                    palindromes.put(right - left, s.substring(left));
                } else {
                    palindromes.put(right - left + 1, s.substring(left, right + 1));
                }
            }
            left--;
            right++;
        }
    }

    private static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }

        boolean palindrome = false;
        String[] source = s.split("");
        String[] reversed = new String[source.length];

        String c;
        for (int i = 0; i < s.length(); i++) {
            c = source[source.length - 1 - i];
            reversed[i] = c;
        }

        String r = Arrays.stream(reversed)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        if (s.equals(r)) {
            palindrome = true;
        }
        return palindrome;
    }
}
