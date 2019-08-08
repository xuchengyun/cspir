package skillp1.bitmanipulation.nandnminus1;

public class _231_PowerOfTwo {

    // n & (n - 1) 去判断是不是2的整数次幂
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }

}
