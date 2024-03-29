package skillp1.stack.leetcode;

import java.util.Stack;

public class _71_SimplifyPath {

    //顺序
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/+");
        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }

        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }

        return res.length() == 0 ? "/" : res;
    }
}
