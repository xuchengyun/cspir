package skillp1.bitmanipulation.bitmap;

public class _268_MissingNumber {

    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i <nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    // 数据量过大怎么办？ 用 bitMap
    // 内存不够， 有1亿个数
    /**
     1. int : 4 byte = 32bit
     2. 对应位置表示数字出现与否
      */

}
