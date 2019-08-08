package skillp1.list.leetcode;

import p1.chapter7.LinkedList.ListNode;

public class _237_DeleteNodeinALinkedList {
    public static void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
