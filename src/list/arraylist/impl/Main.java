package p1.chapter4.myList.impl;

import p1.chapter4.myList.IArrayList;

public class Main {
    public static void main(String[] args) {
        IArrayList arrayList = new ArrayListImpl();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(0, 0);
        arrayList.remove(1);
        arrayList.print();
    }
}
