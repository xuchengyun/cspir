package heap.impl;

import heap.IMaxHeap;

/**
 * 最大堆是一个完全二叉树
完全二叉树:
 除了第h层外， 其它各层(1 ~ h - 1)的节点数都达到最大个数， 第h层所有的节点都连续集中在最左边
 这就是完全二叉树
 */
public class MaxHeapImpl<E extends Comparable<E>> implements IMaxHeap<E> {

    private int capacity;

    private int size;

    private E[] data;

    public MaxHeapImpl() {
        this.capacity = 16;
        this.size = 0;
        this.data = (E[]) new Comparable[capacity];
    }

    public MaxHeapImpl(E[] data) {
        this.capacity = data.length;
        this.size = data.length;
        this.data = data;
        heapify(data);
    }

    /**
     * 1. 找到非叶子节点, 叶子节点都不动
     * 2. 对每个非叶子节点 shift down
     * 3. time complexity：O(n)
     * @param data
     */
    private void heapify(E[] data) {
        //从后到前
        for (int i = getParentIndex(size - 1); i >= 0; i--) {
            siftDownHeapfy(i);
        }
    }

    @Override
    public void offer(E e) {
        if (data.length == size) {
            expandCapacity();
        }
        data[size] = e;
        size++;
        siftUp();
    }

    private void expandCapacity() {
        E[] temp = (E[]) new Comparable[capacity*2];
        for (int i = 0; i < capacity; i++) {
            temp[i] = data[i];
        }
        capacity *= 2;
        data = temp;
    }

    @Override
    public E poll() {
        if (size == 0) {
            throw new IllegalArgumentException("堆为空");
        }
        E item = data[0];
        data[0] = data[size - 1];
        data[size - 1] = null;
        size--;
        siftDown();
        return item;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new IllegalArgumentException("堆为空");
        }
        return data[0];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return  2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return  2 * parentIndex + 2;
    }

    private E leftChild(int index) {
        return data[getLeftChildIndex(index)];
    }

    private E rightChild(int index) {
        return data[getRightChildIndex(index)];
    }

    private E parent(int index) {
        return data[getParentIndex(index)];
    }

    private void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //增加一个节点
    private void siftUp() {
        int index = size - 1;
        while (getParentIndex(index) >= 0 && parent(index).compareTo(data[index]) < 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    //删除一个节点， 用最后一个节点替换掉要删除的节点，然后调整顺序
    private void siftDown() {
        int index = 0;
        //完全二叉树， 只用判断右孩子为空
        while (getLeftChildIndex(index) < size) {
            int biggerChildIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) < size && rightChild(index).compareTo(leftChild(index)) > 0) {
                biggerChildIndex = getRightChildIndex(index);
            }
            if (data[index].compareTo(data[biggerChildIndex]) > 0) {
                break;
            } else {
                swap(index, biggerChildIndex);
            }
            index = biggerChildIndex;
        }
    }

    /**
     * @param index
     */
    private void siftDownHeapfy(int index) {
        while (getLeftChildIndex(index) < size) {
            int biggerChildIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) < size && rightChild(index).compareTo(leftChild(index)) > 0) {
                biggerChildIndex = getRightChildIndex(index);
            }
            if (data[index].compareTo(data[biggerChildIndex]) > 0) {
                break;
            } else {
                swap(index, biggerChildIndex);
            }
            index = biggerChildIndex;
        }
    }
}
