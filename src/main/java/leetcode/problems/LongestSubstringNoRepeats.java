package leetcode.problems;

import java.util.*;

public class LongestSubstringNoRepeats {

    // By using HashSet as a sliding window, checking if a character in the current can be done in O(1)O(1).
    //
    // A sliding window is an abstract concept commonly used in array/string problems.
    // A window is a range of elements in the array/string which usually defined by the start and end indices,
    // i.e. [i, j) (left-closed, right-open). A sliding window is a window "slides" its two boundaries to the
    // certain direction. For example, if we slide [i, j) to the right by 1 element, then it becomes
    // [i+1, j+1) (left-closed, right-open).
    //
    // Back to our problem. We use HashSet to store the characters in current window [i, j)
    // (j = i initially). Then we slide the index jj to the right. If it is not in the HashSet, we slide jj
    // further. Doing so until s[j] is already in the HashSet. At this point, we found the maximum size of
    // substrings without duplicate characters start with index ii. If we do this for all ii, we get our answer.
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> stringSet = new HashSet<>();
        int right = 0;
        int left = 0;
        int ans = 0;
        int n = s.length();
        while (left < n && right < n) {
            if (!stringSet.contains(s.charAt(right))) {
                stringSet.add(s.charAt(right++));
                ans = Math.max(ans, right - left);
            } else {
                stringSet.remove(s.charAt(left++));
            }
        }
        return ans;
    }

    public static int longestNoRepeatsOld(String s) {
        if (s == null) {
            return 0;
        } else if (s.length() == 0) {
            return 0;
        }
        LinkedHashSet<String> subset = new LinkedHashSet<>();
        TreeMap<Integer, String> substrings = new TreeMap<>(Collections.reverseOrder());
        String[] chars = s.split("");
        for (String c : chars) {
            if (subset.contains(c)) {
                // we have a repeat
                Iterator<String> backToString = subset.iterator();
                StringBuffer sb = new StringBuffer();
                while(backToString.hasNext()) {
                    sb.append(backToString.next());
                }
                substrings.put(sb.toString().length(), sb.toString());
                subset.clear();
                subset.add(c);
            } else {
                subset.add(c);
            }
        }
        return substrings.get(substrings.firstKey()).length();
    }
}
