package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static int romanToInt(String s) {
        Map<String, Integer> symbolToValue = new HashMap<>();
        symbolToValue.put("I", 1);
        symbolToValue.put("V", 5);
        symbolToValue.put("X", 10);
        symbolToValue.put("L", 50);
        symbolToValue.put("C", 100);
        symbolToValue.put("D", 500);
        symbolToValue.put("M", 1000);
        String[] ri = s.split("");
        int accumulator = 0;
        for (int i = 0; i < ri.length; i++) {
            if (isFourOrNine(ri, i)) {
                accumulator = accumulator + (symbolToValue.get(ri[i + 1]) - symbolToValue.get(ri[i]));
                i++;
            } else {
                accumulator = accumulator + symbolToValue.get(ri[i]);
            }
        }
        return accumulator;
    }

    private static boolean isFourOrNine(String[] ri, int i) {
        if (i == ri.length -1 ) {
            return false;
        }
        if (ri[i].equals("I") && (ri[i+1].equals("V") || ri[i+1].equals("X"))) {
            return true;
        }
        if (ri[i].equals("X") && (ri[i+1].equals("L") || ri[i+1].equals("C"))) {
            return true;
        }
        if (ri[i].equals("C") && (ri[i+1].equals("D") || ri[i+1].equals("M"))) {
            return true;
        }
        return false;
    }

    private static boolean isIorXorC(String s) {
        boolean is = false;
        if (s.equals("I") || s.equals("X") || s.equals("C")) {
            is = true;
        }
        return is;
    }

    private static boolean isVorXorLorCorDorM(String s) {
        boolean is = false;
        if (s.equals("V") || s.equals("X") || s.equals("L") || s.equals("C") || s.equals("D") || s.equals("M")) {
            is = true;
        }
        return is;
    }
}
