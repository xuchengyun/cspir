package tree.binaryIndexTree;

import java.util.Arrays;

public class BinaryIndexTree {
    
    int[] nums;
    int[] tree;
    
    public BinaryIndexTree(int[] nums) {
        this.tree = new int[nums.length + 1];
        this.nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        for (int j = i + 1; j <= nums.length; j += j & (-j)) {
            tree[j] += diff;
//            System.out.println(j + " " + (-j) + " " + Integer.toBinaryString(-j) + " " + (j & (-j)));
        }
//        System.out.println(Arrays.toString(tree));
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    private int sum(int k) {
        int sum = 0;
        for (int i = k; i > 0; i -= i & (-i)) {
            sum += tree[i];
            System.out.println(i + " " + (-i) + " " + Integer.toBinaryString(-i) + " " + (i & (-i)));
        }
        System.out.println();
        return sum;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5};
        BinaryIndexTree a = new BinaryIndexTree(nums);
        a.sumRange(1,4);
    }
}
