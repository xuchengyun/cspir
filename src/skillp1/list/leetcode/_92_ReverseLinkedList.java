package skillp1.list.leetcode;

import list.LinkedList.ListNode;

public class _92_ReverseLinkedList {

    public ListNode reverseBetween(ListNode head, int m, int n ) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;

        for (int i = 1; i < m; i++) {
            cur = cur.next;
            pre = pre.next;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return dummy.next;
    }
}
