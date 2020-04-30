package leetcode.recursion;

public class PrincipleOfRecursion {

    public void reverseString(char[] s) {
        int head = 0;
        int tail = s.length - 1;
        swap(s, head, tail);
    }

    public void swap(char[] s, int head, int tail) {
        if (head >= tail) {
            return;
        }
        char temp = s[head];
        s[head] = s[tail];
        s[tail] = temp;
        swap(s, head + 1, tail - 1);

    }
}
