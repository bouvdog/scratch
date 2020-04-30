package leetcode.problems;

import java.util.*;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(final String[] words) {
        if (words.length == 0) {
            return "";
        }
        List<String> collWords = new ArrayList<>(Arrays.asList(words));
        Set<String> letters = new LinkedHashSet<>();
        StringBuffer prefix = new StringBuffer();

        String shortest = Collections.min(collWords, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        int length = shortest.length();
        int position = 0;
        String currentLetter = "";
        while (position < length) {
            for (String s : words) {
                String[] chars = s.split("");
                if (currentLetter.length() == 0) {
                    currentLetter = chars[position];
                } else if (!currentLetter.equals(chars[position])) {
                    position = length;
                    currentLetter = "";
                    break;
                }
            }
            if (currentLetter.length() > 0) {
                prefix.append(currentLetter);
                currentLetter = "";
            }
            position++;
        }
        return prefix.toString();
    }
}
