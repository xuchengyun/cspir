package p1.chapter9.queue;

import p1.chapter9.queue.impl.ArrayOfQueueImpl;
import p1.chapter9.queue.impl.ArrrayCircularOfQueueImpl;
import p1.chapter9.queue.impl.LinkedListOfQueueImpl;

public class Main {

    public static void testLinkdeListOfQueue() {
        MyQueue<Integer> queue = new LinkedListOfQueueImpl<>();
        for (int i = 0; i < 8; i++) {
            queue.offer(i);
            queue.print();
        }
        queue.poll();
        queue.print();
        System.out.println(queue.peek());
    }

    public static void testArrayOfQueue() {
        MyQueue<Integer> queue = new ArrayOfQueueImpl<>();
        for (int i = 0; i < 8; i++) {
            queue.offer(i);
            queue.print();
        }
        queue.poll();
        queue.print();
        System.out.println(queue.peek());
    }

    public static void testArrayCircularOfQueue() {
        MyQueue<Integer> queue = new ArrrayCircularOfQueueImpl<>();
        for (int i = 0; i < 11; i++) {
            queue.offer(i);
        }
        queue.print();
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.peek());
    }

    public static void main(String[] args) {
        testArrayCircularOfQueue();
    }
}
