package graph.topologicalSort;

import java.util.LinkedList;
import java.util.Queue;

public class BfsTopologicalSort {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int k = 0;
        /**
         * 1.计算入度
         */
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                res[k++] = i;
            }
        }

        while (!q.isEmpty()) {
            int pre = q.poll();
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) {
                        q.offer(pair[0]);
                        res[k++] = pair[0];
                    }
                }
            }
        }
        return k == numCourses ? res : new int[0];
    }
}
