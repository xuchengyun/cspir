package graph.unionFind.leetcode;

public class _323_NumberOfConnectedComponentsinAnUndirectedGraph {

    int res;

    int count;

    private int[] parents;

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        parents[xRoot] = yRoot;
        res--;
    }

    public int find(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("越界");
        }
        while (index != parents[index]) {
            index = parents[index];
        }
        return index;
    }

    public int countComponents(int n, int[][] edges) {
        //每次少一个集合， 求剩余
        int res = n;
        this.count = n;

        int[] parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int[] pair : edges) {
            int xRoot = find(parents, pair[0]);
            int yRoot = find(parents, pair[1]);
            union(xRoot, yRoot);
        }
        return res;
    }

    private int find(int[] parents, int index) {
        while (index != parents[index]) {
            index = parents[index];
        }
        return index;
    }
}
