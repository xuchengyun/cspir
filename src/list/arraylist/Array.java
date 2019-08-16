package list.arraylist;

import java.util.Arrays;

public class Array {
    public static void array() {
        int[] arr = new int[10];
        int[] array = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(array));
        array[0] = 2;
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            int i1 = array[i];
        }

        for (int a : array) {

        }

        int[][] array2 = new int[][]{
                {1,2,3},
                {1,2,3}
        };
        array2[1][2] = 3;
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[0].length; j++) {
                int[] ints = array2[j];
            }
        }
    }

    public static void main(String[] args) {
        array();
    }
}
