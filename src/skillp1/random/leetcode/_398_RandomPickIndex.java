package skillp1.random.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _398_RandomPickIndex {

    int[] nums;
    Random random;

    public _398_RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        return list.get(random.nextInt(list.size()));
    }

    public int pick2 (int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != target) {
                continue;
            }
            count++;
            if (random.nextInt(count) == 0) {
                res = i;
            }
        }
        return res;
    }
}
