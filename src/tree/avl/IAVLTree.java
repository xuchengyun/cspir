package tree.avl;

public interface IAVLTree {

    void add(int val);

    int size();

    boolean isEmpty();

    void remove(int val);

    boolean contains(int val);
}
