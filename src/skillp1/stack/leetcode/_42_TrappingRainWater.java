package skillp1.stack.leetcode;

import java.util.Stack;

public class _42_TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int idx = 0;
        while (idx < height.length) {
            while (!stack.isEmpty() && height[idx] > height[stack.peek()]) {
                int highIndex = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int dis = idx = stack.peek() - 1;
                int high = Math.min(height[idx], stack.peek()) - height[highIndex];
                res += dis * high;
            }
            stack.push(idx++);
        }
        return res;
    }

}
