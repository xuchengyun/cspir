package skillp1.binarysearch;

import java.util.Arrays;

public class BinarySearch {
    // recursion
    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (high <= low) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, low, mid - 1, target);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, high, target);
        } else {
            return mid;
        }
    }

    /**
     * 迭代写法 <=
     * right < target < left
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // [left, right]
        while (left <= right) { // right + 1 = left 不执行
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) { //[left, mid - 1]
                right = mid - 1;
            } else if (nums[mid] < target) { // [mid + 1, right]
                left = mid + 1;
            } else {
                return mid;
            }
            System.out.println("mid : " + nums[mid] + " left : " + nums[left] + " right: " + nums[right]);
        }
        System.out.println("第一种 left : " + left + " right : " + right);
        return -1;
    }

    /**
     * 迭代写法 <
     * target  < left = right
     * left = right
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // [left, right)
        while (left < right) {   // left = right 不执行
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) { // [left, mid]
                right = mid;
            } else if (nums[mid] < target) { // [mid + 1, right)
                left = mid + 1;
            } else {
                return mid;
            }
            System.out.println("mid : " + nums[mid] + " left : " + nums[left]);
        }
        System.out.println("第二种 left : " + left + " right : " + right);
        return -1;
    }

    /**
     * 迭代写法 left + 1 < right
     * left < target < right
     * left + 1 = right
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // [left, right]
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) { //[left, mid]
                right = mid;
            } else if (nums[mid] < target) { // [mid, right]
                left = mid;
            } else {
                return mid;
            }
            System.out.println("mid : " + nums[mid] + " left : " + nums[left] + " right: " + nums[right]);
        }
        System.out.println("第三种 left : " + left + " right : " + right);
        if (target == nums[left]) {
            return left;
        } else if (target == nums[right]) {
            return right;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 9, 10};
        System.out.println(Arrays.toString(nums) + " target: 6");
        binarySearch3(nums, 6);
    }

}
