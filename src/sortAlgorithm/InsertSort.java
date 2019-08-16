package sortAlgorithm;

public class InsertSort {

    public static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i ++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void insertSortWithBinarySearch(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i + 1];
            int low = 0;
            int high = i;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] < temp) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            for (int j = i; j > high; j--) {
                nums[j + 1] = nums[j];
            }
            nums[high + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,9,4,7,6,1,3,8};
        insertSort(nums);
        for (int num :nums) {
            System.out.println(num);
        }
    }
}
