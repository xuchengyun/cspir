package skillp1.bitmanipulation.nandnminus1;

public class _191_NumbrOf1Bits {

    // n &= (n - 1) 去掉最后一个1
    public int hamingWeight(int n) {
        int res = 0;
         while (n != 0) {
             n &= ( n - 1);
             res++;
         }
         return res;
    }

    //n & 1 拿出最后一个1
    public int hamingWeight2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}
