package hashtable.bloomfilter;

import java.util.BitSet;

/**
 * 1.m位BitSet，初始化为0
 * 2.k个不同的hash function
 * 3.计算当前String 的 k个hash function的值
 * 4.对应BitSet置为1
 * 5. 可能有误差
 * 6. remove 不支持
 */
public class BloomFilter {

    private static final int DEFAULT_SIZE = 1 << 25;

    private BitSet bits = new BitSet(DEFAULT_SIZE);

    private static final int[] seeds = new int[]{5, 7, 11, 13, 37, 51};

    private HashFunction[] functions = new HashFunction[seeds.length];

    public static class HashFunction {
        private int capacity;
        private int seed;

        public HashFunction(int capacity, int seed) {
            this.capacity = capacity;
            this.seed = seed;
        }

        public int hash(String value) {
            int res = 0;
            for (int i = 0; i < value.length(); i++) {
                res = seed * res + value.charAt(i);
            }
            return (capacity - 1) & res;
        }
    }

    public BloomFilter() {
        for (int i = 0; i < seeds.length; i++) {
            functions[i] = new HashFunction(DEFAULT_SIZE, seeds[i]);
        }
    }

    public void add(String value) {
        for (HashFunction function : functions) {
            bits.set(function.hash(value), true);
        }
    }

    public boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean res = true;
        for (HashFunction function : functions) {
            res = res && bits.get(function.hash(value));
        }
        return res;
    }

    public static void main(String[] args) {
        String value = "7788ajq";
        BloomFilter filter = new BloomFilter();
        System.out.println(filter.contains(value));
        filter.add(value);
        System.out.println(filter.contains(value));
    }
}
