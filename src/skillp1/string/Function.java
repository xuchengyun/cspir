package skillp1.string;

import java.util.Arrays;

public class Function {

    // String 是一个对象
    public static void function() {
//        String s1 = "abc";
//        String s2 = "ab";
//        System.out.println(s1.equals(s2));

        char c = 'a';
        int[] count = new int[256];
        count[c] = 1;
        System.out.println(Arrays.toString(count));
    }

    public static void main(String[] args) {
        function();
    }
}
