package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaLoopsII {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();

        List<List<Integer>> variables = new ArrayList<>();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            List<Integer> oneSequence = new ArrayList<>();
            oneSequence.add(a);
            oneSequence.add(b);
            oneSequence.add(n);
            variables.add(oneSequence);
        }

        in.close();

        for (List<Integer> values : variables) {
            int value = values.get(0);
            for (int i = 0; i < values.get(2); i++) {
                value = value + (int) Math.pow(2, i) * values.get(1);
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
