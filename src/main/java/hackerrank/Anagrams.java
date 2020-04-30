package hackerrank;

import java.util.Scanner;

public class Anagrams {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }

    static boolean isAnagram(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        } else {
            char[] f = a.toLowerCase().toCharArray();
            char[] s = b.toLowerCase().toCharArray();
            java.util.Map<Character, Integer> counts = new java.util.HashMap<>();
            java.util.Map<Character, Integer> countsOfSecond = new java.util.HashMap<>();
            for (int i = 0; i < f.length; i++) {
                if (counts.containsKey(f[i])) {
                    Integer cnt = counts.get(f[i]);
                    cnt++;
                    counts.put(f[i], cnt);
                } else {
                    counts.put(f[i], 1);
                }
            }

            for (int i = 0; i < s.length; i++) {
                if (countsOfSecond.containsKey(s[i])) {
                    Integer cnt = countsOfSecond.get(s[i]);
                    cnt++;
                    countsOfSecond.put(s[i], cnt);
                } else {
                    countsOfSecond.put(s[i], 1);
                }
            }

            if (counts.equals(countsOfSecond)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
