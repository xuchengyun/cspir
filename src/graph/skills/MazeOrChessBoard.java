package graph.skills;

import java.util.LinkedList;
import java.util.Queue;

public class MazeOrChessBoard {

    private boolean bfs(char[][] maze, int[] start, int[] end) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int xx = cur[0] + dir[0];
                int yy = cur[1] + dir[1];
                if (isValid(maze, xx, yy) && !visited[xx][yy]) {
                    q.offer(new int[]{xx, yy});
                    visited[xx][yy] = true;
                }
            }
        }
        return false;
    }

    private boolean isValid(char[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1';
    }
}
