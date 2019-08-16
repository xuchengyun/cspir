package list.LinkedList.impl;

import list.LinkedList.ILinkedList;

public class LinkedListImpl<E> implements ILinkedList<E> {

    private int size;
    private ListNode dummy;

    public LinkedListImpl() throws IllegalAccessException, InstantiationException {
        Class<E> clazz = (Class<E>) this.getClass();
        clazz.newInstance();
        this.dummy = new ListNode(clazz.newInstance());
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addIndex(int index, E data) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index 输入错误(小于0或大于已有容量)");
        }

        ListNode pre = dummy;
        for (int i = 0 ; i < index; i++) {
            pre = pre.next;
        }

        ListNode node = new ListNode(data);
        node.next = pre.next;
        pre.next = node;
        size++;
    }

    @Override
    public boolean addElement(E data) {
        addIndex(size, data);
        return true;
    }

    @Override
    public void addFirst(E data) {
        addIndex(0, data);
    }

    @Override
    public void addLast(E data) {
        addIndex(size, data);
    }

    @Override
    public E removeFirst() {
        return removeIndex(0);
    }

    @Override
    public E removeLast() {
        return removeIndex(size - 1);
    }

    @Override
    public boolean removeElement(E data) {
        ListNode prev = dummy;

        while (prev.next != null) {
            if (prev.next.data == data) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            ListNode delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public E removeIndex(int index) {
       if (index < 0 || index >= size) {
           throw new IllegalArgumentException("index 输入错误(小于0或者大于已有容量)");
       }

       ListNode pre = dummy;
       for (int i = 0; i < index; i++) {
           pre = pre.next;
       }

       ListNode delNode = pre.next;
       pre.next = delNode.next;
       delNode.next = null;
       size--;
       return delNode.data;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index 输入错误(小于0或者大于已有容量)");
        }
        ListNode cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    @Override
    public void set(int index, E data) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index 输入错误(小于0或者大于已有容量)");
        }
        ListNode cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = data;
    }

    @Override
    public E getLast() {
        return get(size - 1);
    }

    @Override
    public E getFirst() {
        return get(0);
    }

    @Override
    public boolean contains(E data) {
        ListNode cur = dummy.next;
        while (cur != null) {
            if (cur.data.equals(data)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void print() {
        ListNode cur = dummy.next;
        while (cur != null) {
            System.out.println(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    private class ListNode {
        public E data;
        public ListNode next;

        public ListNode(E data) {
            this.data = data;
            this.next = null;
        }
    }
}
