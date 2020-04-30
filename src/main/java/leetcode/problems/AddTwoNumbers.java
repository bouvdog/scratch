package leetcode.problems;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(final ListNode one, final ListNode two) {
        ListNode startOne = one;
        ListNode startTwo = two;
        ListNode result = null;
        ListNode head = null;
        int carry = 0;
        int sum;
        while (startOne != null && startTwo != null) {
            sum = startOne.val + startTwo.val + carry;
            carry = sum / 10;
            if (carry > 0) {
                sum = sum - 10;
            }
            if (result == null) {
                result = new ListNode(sum);
                head = result;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
            }
            startOne = startOne.next;
            startTwo = startTwo.next;
        }

        if (startOne == null) {
            finish(startTwo, result, carry);
        } else {
            finish(startOne, result, carry);
        }

        return head;
    }

    public static void finish(ListNode start, ListNode result, int carry) {
        int sum;
        while (start != null) {
            sum = start.val + carry;
            carry = sum / 10;
            if (carry > 0) {
                sum = sum - 10;
            }
            result.next = new ListNode(sum);
            result = result.next;
            start = start.next;
        }
        if (carry > 0) {
            result.next = new ListNode(carry);
        }
    }
}
