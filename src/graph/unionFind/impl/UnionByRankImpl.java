package graph.unionFind.impl;

import graph.unionFind.IUnionFind;

public class UnionByRankImpl implements IUnionFind {

    /**
     * 节点个数
     */
    int count;

    /**
     * 节点
     */
    private int[] parents;

    private int[] rank;

    public UnionByRankImpl(int count) {
        this.count = count;
        this.parents = new int[count];
        this.rank = new int[count];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        if (rank[xRoot] < rank[yRoot]) {
            parents[xRoot] = yRoot;
        } else if (rank[yRoot] < rank[xRoot]){
            parents[yRoot] = xRoot;
        } else {
            parents[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    @Override
    public int find(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("越界");
        }
        while (index != parents[index]) {
            index = parents[index];
        }
        return index;
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
