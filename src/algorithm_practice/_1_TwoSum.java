package algorithm_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _1_TwoSum {
    /**
     由于有duplicate, 用hashmap会漏掉一些解
     先sort array， 然后用双指 start 和 end

     * @param nums
     * @param target
     * @return
     */
    public List<int[]> twoSum(int[] nums, int target) {
        List<int[]> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                res.add(new int[]{start, end});
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return res;
    }

}
