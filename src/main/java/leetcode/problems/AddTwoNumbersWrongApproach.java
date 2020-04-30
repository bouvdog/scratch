package leetcode.problems;

public class AddTwoNumbersWrongApproach {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long valuel1 = 0;
        long valuel2 = 0;

        valuel1 = addUpList(l1);
        valuel2 = addUpList(l2);

        long finalValue = valuel1 + valuel2;

        ListNode list = convertIntToList(finalValue);

        return list;
    }

    private static long addUpList(ListNode node) {
        ListNode current = node;
        long place = 1;
        long value = 0;
        while (current != null) {
            value = value + current.val * place;
            current = current.next;
            place = place * 10;
        }
        return value;
    }

    private static ListNode convertIntToList(long num) {
        if (num == 0) {
            return new ListNode(0);
        }
        int length = (int)(Math.log10(num)+1);
        long place = 0;
        int value;
        long accumulator = num;
        ListNode n = null;
        while (length-1 >= 0) {
            place = (long)Math.pow(10, (length - 1));
            value = (int)(accumulator / place);
            if (n == null) {
                n = new ListNode(value);
            } else {
                ListNode m = new ListNode(value);
                m.next = n;
                n = m;
            }
            accumulator = accumulator - value*place;
            length--;
        }
        return n;
    }
}

