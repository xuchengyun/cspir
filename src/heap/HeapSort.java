package heap;

import java.util.Arrays;

public class HeapSort {

    //堆排序
    public static void heapSort(int[] nums) {
        // heapify first，构造一个最大堆
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            heapAdjust(nums, i, nums.length);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapAdjust(nums, 0, i);
        }
    }

    private static void heapAdjust(int[] nums, int start, int length) {
        while (2 * start + 1 < length) {
            int child = 2 * start + 1;
            if (child + 1 < length && nums[child] < nums[child + 1]) {
                child++;
            }
            if (nums[start] < nums[child]) {
                swap(nums, start, child);
            } else {
                break;
            }
            start = child;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 23, 30, 8, 32, 31, 41, 1, 15};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
