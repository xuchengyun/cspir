package skillp2.pq;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void compare2() {
        int[] nums = new int[]{1, 2, 3, 4};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public static void compare3() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.a - o2.a;
            }
        });

        String[] strings = new String[]{"12", "23"};
        Arrays.sort(strings, (o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o1;
            return s1.compareTo(s2);
        });
    }

    public static void compare4() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(5, (a, b) -> (a.a - b.a));
    }

    class Node {
        int a;
        int b;
    }
}
