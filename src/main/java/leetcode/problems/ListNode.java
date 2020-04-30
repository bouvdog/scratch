package leetcode.problems;

public class ListNode {
    public final int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
