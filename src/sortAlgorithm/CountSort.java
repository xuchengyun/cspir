package p1.chapter5.sortAlgorithm;

public class CountSort {

    public static void countSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] = count[nums[i]] + 1;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }
}
