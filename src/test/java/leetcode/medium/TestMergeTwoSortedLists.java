package leetcode.medium;

import leetcode.problems.ListNode;
import leetcode.problems.MergeTwoSortedLists;
import org.junit.jupiter.api.Test;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMergeTwoSortedLists {

    @Test
    public void whenTwoSortedLists_returnOneSortedList() {


        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(4);
        ln1.next = ln2;
        ln2.next = ln3;

        ListNode lnOther1 = new ListNode(1);
        ListNode lnOther2 = new ListNode(3);
        ListNode lnOther3 = new ListNode(4);
        lnOther1.next = lnOther2;
        lnOther2.next = lnOther3;

        ListNode listResult1 = new ListNode(1);
        ListNode listResult2 = new ListNode(1);
        ListNode listResult3 = new ListNode(2);
        ListNode listResult4 = new ListNode(3);
        ListNode listResult5 = new ListNode(4);
        ListNode listResult6 = new ListNode(4);

        listResult1.next = listResult2;
        listResult2.next = listResult3;
        listResult3.next = listResult4;
        listResult4.next = listResult5;
        listResult5.next = listResult6;


        ListNode result = MergeTwoSortedLists.merge(ln1, lnOther1);

        while (result != null) {
            assertEquals(listResult1.val, result.val);
            result = result.next;
            listResult1 = listResult1.next;
        }

    }
}
