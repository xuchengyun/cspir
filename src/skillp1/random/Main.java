package skillp1.random;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rmd = new Random();
        int random = rmd.nextInt(10);
        System.out.println(random);
    }
}
