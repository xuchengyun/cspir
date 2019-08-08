package skillp1.math.leetcode;

public class _367_ValidPerfectSquare {
    /**
     * 通用解法
     * 1.二分法
     * 2.x*x > num
     * 3.牛顿法
     */

    // 二分法
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int)mid + 1;
            } else {
                high = (int)mid - 1;
            }
        }
        return false;
    }

    //x*x > num
    public boolean isPerfectSquare2(int num) {
        if (num < 0) return false;
        if (num == 1) return true;
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) return true;
        }
        return false;
    }

    //牛顿法
    public boolean isPerfectSquare3(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) /2;
        }
        return x * x == num;
    }
}
