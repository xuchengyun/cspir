package dynamicprogramming;

//原型代码
public class MultipleKnapsack {

    public int multipleKnapsack(int[] weight, int[] value, int[] nums, int C, int N) {
        int[] memo = new int[C + 1];

        for (int i = 0; i < N; i++) {
            for (int j = C; j >= weight[i]; j--) {
                for (int k = 0; k <= nums[i]; k++) {
                    if (j - k * weight[i] >= 0) {
                        memo[j] = Math.max(memo[j], k * value[i] + memo[j - k * weight[i]]);
                    }
                }
                memo[j] = Math.max(memo[j], value[i] + memo[j - weight[i]]);
            }
        }
        return memo[C];
    }
}
