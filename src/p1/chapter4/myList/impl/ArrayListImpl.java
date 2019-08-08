package p1.chapter4.myList.impl;

import p1.chapter4.myList.IArrayList;

import java.util.Arrays;

public class ArrayListImpl implements IArrayList {

    private int[] data;

    private int size;

    public ArrayListImpl() {
        this.data = new int[10];
        this.size = 0;
    }

    public ArrayListImpl(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    @Override
    public int caparity() {
        return data.length;
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
    public void add(int element) {
        add(size, element);
    }

    @Override
    public void add(int index, int element) {
        if (size == data.length) {
            resize(2 * size);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index 输入错误 （小于0 或大于初始化容量）");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    @Override
    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (element == data[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index 输入错误 （小于0 或大于初始化容量）");
        }
        return data[index];
    }

    @Override
    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index 输入错误 （小于0 或大于初始化容量）");
        }
        data[index] = element;
    }

    // lazy 思想
    @Override
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index 输入错误 （小于0 或大于初始化容量）");
        }
        int res = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        if (data.length /4 >= size && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return res;
    }


    @Override
    public int removeElement(int element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                index = i;
                remove(index);
                return index;
            }
        }
        throw new IllegalArgumentException("元素不存在");
    }

    @Override
    public void print() {
        System.out.println("size : " + size);
        System.out.println("capacity : " + data.length);
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
    }

    @Override
    public String toString() {
        return "ArrayListImpl{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    @Override
    public void resize(int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
