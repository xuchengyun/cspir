package p1.chapter8.stack;

public class StackIteration {

    public static int sum;

    public static void sumOfN1(int num) {
        if (num == 0) {
            return;
        }
        sum+= num;
        sumOfN1(num - 1);
    }

    public static int sumOfN2(int num) {
        if (num == 0) {
            return 0 ;
        }
        return num + sumOfN2(num - 1);
    }

    public static int iteration(int num) {
        int sum = 0;
        while (num >= 1) {
            sum += num;
            num --;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfN2(10));
        System.out.println(iteration(10));
    }
}
