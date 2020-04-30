package hackerrank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public class JavaLoopsI {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        List<Integer> numbers = IntStream.range(1, 11).boxed().map(i -> N * i).collect(toCollection(ArrayList::new));
        IntStream.range(1, 11).boxed().forEach(i -> System.out.println(N + " x " + i + " = " +
                numbers.get(--i)));
    }
}
