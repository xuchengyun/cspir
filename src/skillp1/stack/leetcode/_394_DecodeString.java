package skillp1.stack.leetcode;

import java.util.Stack;

public class _394_DecodeString {

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Integer> numStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        String res = "";
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int num = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + s.charAt(idx) - '0';
                    idx++;
                }
                numStack.push(num);
            } else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int time = numStack.pop();
                for (int i = 0; i < time; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;

            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
