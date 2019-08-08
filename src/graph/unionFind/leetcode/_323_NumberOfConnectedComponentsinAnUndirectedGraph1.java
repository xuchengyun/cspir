package graph.unionFind.leetcode;

public class _323_NumberOfConnectedComponentsinAnUndirectedGraph1 {

    int res;
    /**
     * 节点个数
     */
    int count;

    /**
     * 节点
     */
    private int[] id;

    public int count() {
        return count;
    }

    public void union(int x, int y) {
        int A = find(x);
        int B = find(y);
        if (A == B) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == A) {
                id[i] = B;
            }
        }
        res--;
    }

    public int find(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("越界");
        }
        return id[index];
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public int countComponents(int n, int[][] edges) {
        res = n;
        this.count = n;
        id = new int[count];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }

        for (int[] pair : edges) {
            int A = find(pair[0]);
            int B = find(pair[1]);
            union(A, B);
        }
        return res;
    }
}
