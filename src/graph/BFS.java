package graph;

import java.util.*;

public class BFS {

    public static void bfs(GraphNode graphNode) {
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> q = new LinkedList<>();

        visited.add(graphNode);
        q.offer(graphNode);
        while (!q.isEmpty()) {
            GraphNode node = q.poll();
            System.out.println(node.label);
//          visited.add(node);
            for (GraphNode neighbor : node.neighbors) {
                if (!visited.contains(neighbor)) {
                    q.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    // 层序遍历 最短距离
    public static void bfs2(GraphNode graphNode) {
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> q = new LinkedList<>();

        visited.add(graphNode);
        q.offer(graphNode);
        while (!q.isEmpty()) {
            int size= q.size();
            for (int i = 0; i < size; i++) {
                GraphNode node = q.poll();
                System.out.println(node.label);
                for (GraphNode neighbor : node.neighbors) {
                    if (!visited.contains(neighbor)) {
                        q.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            System.out.println();
//          visited.add(node);
        }


    }

    public static void bfsMatrix(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                q.offer(i);
                while (!q.isEmpty()) {
                    Integer vertex = q.poll();
                    System.out.println(vertex);
                    for (int j = 0; j < matrix.length; j++) {
                        if (matrix[vertex][j] == 1) {
                            if (visited[j] == 0) {
                                q.offer(j);
                                visited[j] = 1;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void bfsMatrix2(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                q.offer(i);
                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int k = 0; k < size; k++) {
                        Integer vertex = q.poll();
                        System.out.println(vertex);
                        for (int j = 0; j < matrix.length; j++) {
                            if (matrix[vertex][j] == 1) {
                                if (visited[j] == 0) {
                                    q.offer(j);
                                    visited[j] = 1;
                                }
                            }
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphNode a = new GraphNode(0);
        GraphNode b = new GraphNode(1);
        GraphNode c = new GraphNode(2);
        GraphNode d = new GraphNode(3);
        GraphNode e = new GraphNode(4);
        GraphNode f = new GraphNode(5);

        a.neighbors.add(b);
        a.neighbors.add(d);
        a.neighbors.add(f);

        b.neighbors.add(a);
        b.neighbors.add(e);
        b.neighbors.add(c);

        c.neighbors.add(b);
        c.neighbors.add(e);

        d.neighbors.add(a);
        d.neighbors.add(e);

        e.neighbors.add(d);
        e.neighbors.add(c);
        e.neighbors.add(d);

        f.neighbors.add(a);

        int[][] matrix = new int[][] {
                {0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 1, 0},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0},
        };
//        bfs(a);
//        bfs2(a);
        bfsMatrix2(matrix);
    }
}
