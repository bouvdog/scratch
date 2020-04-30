import leetcode.recursion.ListNode;
import leetcode.recursion.ListNodeSolution;
import org.junit.jupiter.api.Test;

public class TestListSwap {
    @Test
    public void testNodeSwap() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNodeSolution lns = new ListNodeSolution();
        ListNode result = lns.swapPairs(l1);
        System.out.println(result);

    }
}
