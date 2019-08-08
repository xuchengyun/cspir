package skillp1.math;

public class bibei {
    public static void main(String[] args) {
        int num = 1;
        int res = 0;
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
    }
}
