package p1.chapter8.stack;

public interface ILinkedListStack<E> {
    int size();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();

    void print();
}
