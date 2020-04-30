package leetcode.problems;

import java.util.List;

public class MergeTwoSortedLists {

    public static ListNode merge(ListNode listOne, ListNode listTwo) {
        // we set up a false "prehead" node that allows us to easily return the head of the merged list later.
        // We also maintain a prev pointer, which points to the current node for which we are considering
        // adjusting its next pointer. Then, we do the following until at least one of l1 and l2 points to null:
        // if the value at l1 is less than or equal to the value at l2, then we connect l1 to the previous node
        // and increment l1. Otherwise, we do the same, but for l2. Then, regardless of which list we connected,
        // we increment prev to keep it one step behind one of our list heads.
        //
        //After the loop terminates, at most one of l1 and l2 is non-null. Therefore (because the input lists
        // were in sorted order), if either list is non-null, it contains only elements greater than all of
        // the previously-merged elements. This means that we can simply connect the non-null list to the
        // merged list and return it.

        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while (listOne != null && listTwo != null) {
            if (listOne.val <= listTwo.val) {
                prev.next = listOne;
                listOne = listOne.next;
            } else {
                prev.next = listTwo;
                listTwo = listTwo.next;
            }
            prev = prev.next;
        }
        if (listOne == null) {
            prev.next = listTwo;
        } else {
            prev.next = listOne;
        }
        return prehead.next;
    }
}
