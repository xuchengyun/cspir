package amazon;

import list.LinkedList.ListNode;

import java.util.HashMap;

public class _146_LRUCache {

    int capacity;
    ListNode head;
    ListNode tail;
    HashMap<Integer, ListNode> map;

    public _146_LRUCache(int capacity) {
        head = new ListNode(0);
        tail = new ListNode(0);
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode cur = map.get(key);
            cur.next.pre = cur.pre;
            cur.pre.next = cur.next;
            appendToHead(cur);
            return cur.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode cur = map.get(key);
            cur.next.pre = cur.pre;
            cur.pre.next = cur.next;
            appendToHead(cur);
            cur.val = value;
        } else {
            if (map.size() == capacity) {
                ListNode last = tail.pre;
                last.pre.next = last.next;
                last.next.pre = last.pre;
                map.remove(key);
            }
            ListNode node = new ListNode(value);
            appendToHead(node);
            map.put(key, node);
        }
    }

    private void appendToHead(ListNode cur) {
        cur.pre = head;
        cur.next = head.next;
        head.next.pre = cur;
        head.next = cur;
    }
}
