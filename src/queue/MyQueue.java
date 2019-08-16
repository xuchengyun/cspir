package p1.chapter9.queue;

public interface MyQueue<E> {

    int size();

    boolean isEmpty();

    boolean offer(E e);

    E poll();

    E peek();

    void print();



}
