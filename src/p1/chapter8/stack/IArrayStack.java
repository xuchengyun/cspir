package p1.chapter8.stack;

public interface IArrayStack<E> {
    int capacity();

    int size();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();

    void resize(int size);

    void print();
}
