package hashtable.seperateChaining.impl;

import hashtable.IHashtable;

public class Main {

    public static void main(String[] args) {
        IHashtable<Integer, Integer> hashtable = new HashTableSeparateChainingImpl<>();
        hashtable.put(1, 1);
        hashtable.put(11, 1);
        hashtable.put(21, 1);
        hashtable.put(12, 1);
        hashtable.put(22, 1);

        hashtable.print();
        hashtable.delete(21);
        hashtable.print();
    }
}
