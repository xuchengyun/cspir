package graph.unionFind.leetcode;

public class _323_NumberOfConnectedComponentsinAnUndirectedGraphFinal {

    public int countComponents(int n, int[][] edges) {
        //每次少一个集合， 求剩余
        int res = n;
        int[] parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int[] pair : edges) {
            int x = find(parents, pair[0]);
            int y = find(parents, pair[1]);
            if (x != y) {
                parents[x] = y;
                res--;
            }
        }
        return res;
    }

    private int find(int[] parents, int index) {
        while (index != parents[index]) {
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }

    public int find2(int[] parents,int index) {
        while (index != parents[index]) {
            index = parents[index];
        }
        return index;
    }
}
