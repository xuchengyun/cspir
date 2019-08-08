package skillp1.random.leetcode;

import java.util.Random;

public class _384_ShuffleAnArray {

    private int[] nums;
    private Random rmd;

    public _384_ShuffleAnArray(int[] nums) {
        this.nums = nums;
        this.rmd = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        if (nums == null) return nums;
        int[] clone = nums.clone();
        for (int i = 1; i < clone.length; i++) {
            int random = rmd.nextInt(i + 1);
            swap(clone, i, random);
        }
        return clone;
    }

    private void swap(int[] clone, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
