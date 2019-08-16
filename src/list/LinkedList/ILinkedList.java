package p1.chapter7.LinkedList;

public interface ILinkedList<E> {

    int size();

    boolean isEmpty();

    void addIndex(int index, E data);

    boolean addElement(E data);

    void addFirst(E data);

    void addLast(E data);

    E removeFirst();

    E removeLast();

    boolean removeElement(E data);

    E removeIndex(int index);

    E get(int index);

    void set(int index, E data);

    E getLast();

    E getFirst();

    boolean contains(E data);

    void print();
}

