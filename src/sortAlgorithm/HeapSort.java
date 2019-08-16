package sortAlgorithm;

public class HeapSort {

    public static void heapSort(int[] nums) {
        for (int i = (nums.length - 2) / 2; i >= 0; i++) {
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
}
