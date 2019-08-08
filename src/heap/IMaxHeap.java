package heap;

public interface IMaxHeap<E> {

    void offer(E item);

    E poll();

    E peek();

    int size();

    boolean isEmpty();

    void print();
}
