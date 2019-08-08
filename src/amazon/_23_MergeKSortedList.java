package amazon;

import p1.chapter7.LinkedList.ListNode;

public class _23_MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start >= end) return lists[start];
        int mid = start + (start - end) / 2;
        ListNode left = merge(lists, start, mid - 1);
        ListNode right = merge(lists, mid, end);
        return mergeTwoSortedList(left, right);

    }

    private ListNode mergeTwoSortedList(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.val < right.val) {
            left.next = mergeTwoSortedList(left.next, right);
            return left;
        } else {
            right.next = mergeTwoSortedList(left, right.next);
            return right;
        }
    }
}
