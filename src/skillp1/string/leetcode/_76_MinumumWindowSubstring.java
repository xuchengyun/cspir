package skillp1.string.leetcode;

public class _76_MinumumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] count = new int[256];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int len = t.length();
        int j = 0;
        int res = Integer.MAX_VALUE;
        int from = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]-- > 0) {
                len--;
            }
            while (len == 0) {
                if (i - j + 1 < res) {
                    res = i - j + 1;
                    from = j;
                }
                if (++count[s.charAt(j++)] > 0) {
                    len++;
                }
            }
        }
        return (res == Integer.MAX_VALUE) ? "":s.substring(from, from + res);
    }
}
