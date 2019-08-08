package algorithm_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array arr[], the task is to make all the array elements equal with the given operation.
 * In a single operation, any element of the array can be either multiplied by 2 or by 3.
 * If its possible to make all the array elements equal with the given operation then print Yes else print No.

 Examples:

 Input: arr[] = {50, 75, 100}
 Output: Yes
 {50 * 2 * 3, 75 * 2 * 2, 100 * 3} = {300, 300, 300}

 Input: arr[] = {10, 14}
 Output: No
 {50, 75, 100}
 25 * 2
 25 * 3
 25 * 2 * 2

 */
public class Exercise {
    boolean canFind(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (true) {
                if (arr[i] % 2 == 0) {
                    arr[i] /= 2;
                } else if (arr[i] % 3 == 0) {
                    arr[i] /= 3;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

/**    Given an array of non-negative integers arr[]. The task is to find the largest number in the array which is palindrome. If no such number exits then print -1.

    Examples:

    Input: arr[] = {1, 232, 54545, 999991};
    Output: 54545

    Input: arr[] = {1, 2, 3, 4, 5, 50};
    Output: 5
    */
    int findLargestInParlindrome(int arr[]) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (isParlindrome(arr[i])) {
                if (arr[i] > res) {
                    res = arr[i];
                }
            }
        }
        return res;
    }

    // 123321
    // 11
    private boolean isParlindrome(int n) {
        int temp = 0;
        while (n > 0) {
            temp = temp * 10 + n % 10;
            n /= 10;
        }
        return temp == n;
    }

    /**
     * [0,2,4,4,7,10]\
     * [1 2 7]
     * [0->4/2, 4->10/3]
     * @param nums
     * @return
     */
    public static List<String> summaryRanges(int[] nums) {
        int j = 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            j = i;
            while (i < nums.length - 2 && nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i]) {
                i++;
            }
            if (i != j) {
                int diff = nums[i + 1] - nums[i];
                int start = nums[j];
                int end = nums[i + 1];
                res.add(start + "->" + end + "/" + diff);
                i++;
            } else {
                int num = nums[i];
                res.add(String.valueOf(num));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {0,2,4,4,7,10,13, 1,2,3,4,7};
        System.out.println(summaryRanges(arr).toString());
    }
}
