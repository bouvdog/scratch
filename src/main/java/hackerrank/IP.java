package hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IP {
    public static void main(String[] args) {
        String ipPattern = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        Pattern p = Pattern.compile(ipPattern);

        String bad = "666.666.23.23";
        Matcher m = p.matcher(bad);
        System.out.println(m.matches());

        String good = "000.12.12.034";
        Matcher m1 = p.matcher(good);
        System.out.println(m1.matches());

    }
}
