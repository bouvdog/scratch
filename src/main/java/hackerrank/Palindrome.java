package hackerrank;

public class Palindrome {

    public static void main(String[] args) {
        String s = "madam";

        char[] source = s.toCharArray();
        char[] reversed = new char[source.length];

        for (int i=0;i<s.length();i++) {
            char c = source[source.length-1-i];
            reversed[i]= c;
        }

        String palindrome = String.valueOf(reversed);
        System.out.println(palindrome);
    }

}
