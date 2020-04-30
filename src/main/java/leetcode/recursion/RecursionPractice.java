package leetcode.recursion;

public class RecursionPractice {

    public int displayArray(int[] x, int index) {
        if (index == x.length) {
            return 0;
        }
        System.out.println(x[index]);
        index++;
        return displayArray(x, index);
    }

    public static void main(String[] args) {
        RecursionPractice rp = new RecursionPractice();
        int[] one2three4 = {1, 2, 3, 4};
        rp.displayArray(one2three4,0);
    }
}
