package stack;

public class StackRecursion {

    public static void test() {
        test1();
    }

    public static void test1() {
        System.out.println("第一个调用");
        test2();
        System.out.println("第一个调用结束");
    }

    public static void test2() {
        System.out.println("第二个调用");
        test3();
        System.out.println("第二个调用结束");
    }

    public static void test3() {
        System.out.println("第三个调用");
        System.out.println("第三个调用结束");
    }

    public static int f1(int num) {
        if (num == 1) {
            return 1;
        }
        return f1(num - 1);
    }

    public static int f2(int num) {
        if (num == 1) {
            return 1;
        }
        return 1 + f2(num - 1);
    }

    public static void main(String[] args) {
        test();
    }


}