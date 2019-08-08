package skillp1.string.leetcode;

import java.util.HashMap;

public class _246_StrobogrammaticNumber {
    public boolean isStrobogrammic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            if (!map.containsKey(num.charAt(left))) {
                return false;
            }
            if (!map.containsKey(num.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
