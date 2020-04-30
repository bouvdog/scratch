package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATOI {

    enum Sign {POS, NEG}

    public static int atoi(final String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // If given something that doesn't start with a number
        String n = s.trim();
        //Pattern match = Pattern.compile("^[+-]?\\d+.*");
        Pattern match = Pattern.compile("^[+-]?[0-9]+ ?.*");
        Matcher m = match.matcher(n);
        if (!m.matches()) {
            return 0;
        }

        Sign sign = Sign.POS;
        String mathOp = n.substring(0, 1);
        if (mathOp.equals("-")) {
            sign = Sign.NEG;
            n = n.substring(1);
        } else if (mathOp.equals("+")) {
            n = n.substring(1);
        }

        String[] justDigits = n.split("");
        StringBuffer jd = new StringBuffer();
        Set<String> z = new HashSet<>();
        z.add("0");
        z.add("1");
        z.add("2");
        z.add("3");
        z.add("4");
        z.add("5");
        z.add("6");
        z.add("7");
        z.add("8");
        z.add("9");
        for (String c : justDigits) {
            if (z.contains(c)) {
                jd.append(c);
            } else {
                if (c.equals(" ")) {
                    break;
                } else {
                    return 0;
                }
            }
        }
        n = jd.toString();

        Map<String, Long> atoiTable = new HashMap<>();
        atoiTable.put("1", 1L);
        atoiTable.put("2", 2L);
        atoiTable.put("3", 3L);
        atoiTable.put("4", 4L);
        atoiTable.put("5", 5L);
        atoiTable.put("6", 6L);
        atoiTable.put("7", 7L);
        atoiTable.put("8", 8L);
        atoiTable.put("9", 9L);
        atoiTable.put("0", 0L);


        String[] digits = n.split("");
        Long accumulator = 0L;
        for (int i = 0; i < digits.length; i++) {
            int power = (int) Math.pow(10, (digits.length - 1 - i));
            accumulator = accumulator + atoiTable.get(digits[i]) * power;

        }
        if (sign.equals(Sign.NEG)) {
            accumulator = accumulator*-1;
        }

        if (accumulator > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (accumulator < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return accumulator.intValue();
    }
}
