package hackerrank;

public class SubstringCompare {

    public static void main (String[] args) {
        String s = "welcometojava";
        java.util.List<String> substrings = new java.util.ArrayList<>();
        for (int i = 0; i < s.length()-2; i++) {
            substrings.add(s.substring(i,i+3));
        }

        int lex = 0;
        String largest = substrings.get(0);
        for (int i = 1; i<substrings.size(); i++) {
            lex = substrings.get(i).compareTo(largest);
            if (lex > 0) {
                largest = substrings.get(i);
            }
        }

        String smallest = substrings.get(0);
        for (int i = 1; i<substrings.size(); i++) {
            lex = substrings.get(i).compareTo(smallest);
            if (lex <= 0) {
                smallest = substrings.get(i);
            }
        }

        System.out.println(smallest);
        System.out.println(largest);

    }
}
