package wtf;

import java.util.Arrays;

public class Hungary {

    int[] person;
    int[] places;

    public void match(int[][] matrix) {
        person = new int[4];
        places = new int[3];
        Arrays.fill(person, -1);
        Arrays.fill(places, -1);
        boolean[] visited ;
        int res = 0;
        for (int i = 0; i < person.length; i++) {
            visited = new boolean[places.length];
            if (hungary(matrix, i, visited)) {
                res++;
            }
        }
    }

    public boolean hungary(int[][] matrix, int start, boolean[] visited) {
        for (int end = 0; end < places.length; end++) {
            //没有边 or 访问过了
            if (matrix[start][end + 4] == 0 || visited[end]) {
                continue;
            }
            visited[end] = true;
            // 1,没用占用， 2,是否可以让位置
            if (places[end] == -1 || hungary(matrix, places[end], visited)) {
                person[start] = end;
                places[end] = start;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
