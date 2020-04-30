package hackerrank;

import java.util.Arrays;
import java.util.stream.Stream;

public class Splitter {

    public static void main(String[] args) {
        //String s = "He is a very very good boy, isn't he?";
        String s = "          YES      leading spaces        are valid,    problemsetters are         evillllll";
        s = s.trim();
        String[] tokens = s.split("[ !,?._'@]+");
        System.out.println(tokens.length);
        Stream<String> tokenStream = Arrays.stream(tokens);
        tokenStream.forEach(System.out::println);

    }
}
