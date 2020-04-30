import leetcode.problems.AddTwoNumbers;
import leetcode.problems.AddTwoNumbersWrongApproach;
import leetcode.problems.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAddTwoNumbers {

    @Test
    public void givenIntegersRepresentedByLists_whenTwoLists_thenReturnSum() {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(1);

        ListNode result = AddTwoNumbers.addTwoNumbers(n0, n1);
        assertEquals(2, result.val);

        // 29
        n0 = new ListNode(9);
        n1 = new ListNode(2);
        n0.next = n1;

        // 31
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        n2.next = n3;

        result = AddTwoNumbers.addTwoNumbers(n0, n2);
        assertEquals(result.val, 0);
        assertEquals(result.next.val, 6);

        // Test where the two lists are not the same length
        // 1
        n0 = new ListNode(1);

        // 33
        n2 = new ListNode(3);
        n3 = new ListNode(3);
        n2.next = n3;
        result = AddTwoNumbers.addTwoNumbers(n0, n2);
        assertEquals(result.val, 4);
        assertEquals(result.next.val, 3);

        result = AddTwoNumbers.addTwoNumbers(n2, n0);
        assertEquals(result.val, 4);
        assertEquals(result.next.val, 3);

        // Test where two lists are the same length but with a carry
        n0 = new ListNode(1);
        n1 = new ListNode(9);
        result = AddTwoNumbers.addTwoNumbers(n1, n0);
        assertEquals(result.val, 0);
        assertEquals(result.next.val, 1);



        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        long start = System.currentTimeMillis();
        ListNode value = AddTwoNumbersWrongApproach.addTwoNumbers(l1, l4);
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println("Time: " + elapsed);
        System.out.println(value.getVal() + " " + value.next.getVal() + " " + value.next.next.getVal());

        l1 = new ListNode(0);
        l2 = new ListNode(0);
        value = AddTwoNumbersWrongApproach.addTwoNumbers(l1, l2);
        System.out.println(value.getVal());

        l1 = new ListNode(9);

        l2 = new ListNode(1);
        l3 = new ListNode(9);
        l4 = new ListNode(9);
        l5 = new ListNode(9);
        l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        l10.next = l11;

        value = AddTwoNumbersWrongApproach.addTwoNumbers(l1, l2);
        while (value != null) {
            System.out.print(value.getVal());
            value = value.next;
        }
        System.out.println();
    }
}
