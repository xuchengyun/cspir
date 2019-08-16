package dynamicprogramming.leetcode;

import java.util.Arrays;

public class _509_FibonacciNumber {

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }

    int[] memo = new int[10];

    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        if (memo[N] == 0) {
            memo[N] = fib2(N - 1) + fib2(N - 2);
        }
        System.out.println(Arrays.toString(memo));
        return memo[N];
    }

    public int fib3(int N) {
        if (N <= 1) {
            return N;
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    public int fib4(int N) {
        if (N <= 1) {
            return N;
        }
        int a = 0, b = 1;
        while (N-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void main(String[] args) {
        _509_FibonacciNumber temp = new _509_FibonacciNumber();
        temp.fib2(5);
    }
}
