package com.tianyangche;

public class ReverseLinkedListII {
    /**
     *
     Reverse a linked list from position m to n. Do it in one-pass.

     Note: 1 ≤ m ≤ n ≤ length of list.

     Example:

     Input: 1->2->3->4->5->NULL, m = 2, n = 4
     Output: 1->4->3->2->5->NULL
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = curr.next;
        int count = 1;
        while (count < m) {
            prev = prev.next;
            curr = curr.next;
            next = next.next;
            count++;
        }
        while (count < n) {
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = curr.next;
            count++;
        }
        return dummy.next;
    }
}
