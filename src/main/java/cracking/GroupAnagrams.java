package cracking;

import java.util.ArrayList;

public class GroupAnagrams {

    public static ArrayList<String> group(ArrayList<String> list) {
        // Are anagrams present in the list?
        return null;
    }

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        for (int i = 0; i<aChars.length; i++) {
            boolean isAInB = false;
            for(int j = 0; j<bChars.length; j++) {
                if (aChars[i] == bChars[j]) {
                    isAInB = true;
                    break;
                }
            }
            if (!isAInB) {
                return false;
            }
        }
        return true;
    }
}
