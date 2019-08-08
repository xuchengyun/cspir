package skillp1.bitmanipulation;

public class Main {

    public static void main(String[] args) {
        int[] count = new int[256];

        String s = "123";
        for (char c : s.toCharArray()) {
//            count[c - 0] ++;
            System.out.println(c - '0');
        }
        System.out.println((int)'1');
    }
}
