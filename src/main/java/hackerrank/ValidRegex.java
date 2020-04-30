package hackerrank;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ValidRegex {

    public static void main(String[] args) {
        // String s = "[AZ[a-z](a-z)";
        String s = "3";
        try {
            Pattern p = Pattern.compile(s);
            System.out.println("Valid");
        } catch (PatternSyntaxException pse) {
            System.out.println("Invalid");
        }


    }
}
