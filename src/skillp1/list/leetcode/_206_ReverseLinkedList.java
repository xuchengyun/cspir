package skillp1.list.leetcode;

import p1.chapter7.LinkedList.ListNode;

public class _206_ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1->2->3
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }
}
