package pq.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// external sort
public class MergeKSortedArrays {

    public static int[] mergeKSortedArrays(int[][] arrays) {
        List<Integer> ret = new ArrayList<>();
        if (arrays == null || arrays.length == 0) {
            return new int[]{};
        }
        //需要存index
        PriorityQueue<ArrayContainer> pq = new PriorityQueue<>();
        for (int i = 0 ; i < arrays.length; i++) {
            if (arrays[i].length != 0) {
                ArrayContainer ac = new ArrayContainer(arrays[i], 0);
                pq.offer(ac);
            }
        }
        while (!pq.isEmpty()) {
            ArrayContainer ac = pq.poll();
            ret.add(ac.array[ac.index++]);
            if (ac.index < ac.array.length) {
                pq.offer(new ArrayContainer(ac.array, ac.index));
            }
        }
        int[] res = new int[ret.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ret.get(i);
        }
        return res;
    }

    private static class ArrayContainer implements Comparable<ArrayContainer>{
        int[] array;
        int index;
        public ArrayContainer(int[] array, int index) {
            this.array = array;
            this.index = index;
        }
        @Override
        public int compareTo(ArrayContainer o) {
            return this.array[index] - o.array[o.index];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] arr3 = {0, 9, 10, 11};
    }
}
