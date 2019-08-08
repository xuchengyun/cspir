package graph.skills;

import java.util.LinkedList;
import java.util.Queue;

public class _200_NumberofIslands {

    private int m;
    private int n;
    // flood fill
    public int numIsLands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    floodFillDfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void floodFillDfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m ||j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        floodFillDfs(grid, i, j + 1);
        floodFillDfs(grid, i, j - 1);
        floodFillDfs(grid, i + 1, j);
        floodFillDfs(grid, i - 1, j);
    }

    // bfs 最终优化
    private void bfs(char[][] grid, int x, int y) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        grid[x][y] = '0';
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int xx = cur[0] + dir[0];
                int yy = cur[1] + dir[1];
                if (isValid(grid, xx, yy)) {
                    q.offer(new int[]{xx, yy});
                    grid[xx][yy] = 0;
                }
            }
        }
    }

    private boolean isValid(char[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1';
    }
}
