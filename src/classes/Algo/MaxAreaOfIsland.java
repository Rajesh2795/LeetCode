package classes.Algo;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] != 0) {
                    int currentMaxArea = dfs(grid, i, j, visited);
                    System.out.println("Entering coordinates " + i + " and " + j);
                    System.out.println("Max Area for coordinates " + i + " and " + j + ": " + currentMaxArea);
                    maxArea = Math.max(maxArea, currentMaxArea);
                } else {
                    visited[i][j] = true;
                    System.out.println("Skipping coordinates " + i + " and " + j);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int area = 0;
        Deque<GraphCoordinates> deque = new ArrayDeque<>();
        deque.push(new GraphCoordinates(i, j));
        visited[i][j] = true;

        while (!deque.isEmpty()) {
            GraphCoordinates graphCoordinates = deque.pop();
            area += grid[graphCoordinates.x][graphCoordinates.y];
            pushChildren(graphCoordinates.x, graphCoordinates.y, visited, grid, deque);
        }

        return area;
    }

    public void pushChildren(int i, int j, boolean[][] visited, int[][] grid, Deque<GraphCoordinates> deque) {
        if (i - 1 >= 0 && grid[i - 1][j] != 0 && !visited[i - 1][j]) {
            deque.push(new GraphCoordinates(i - 1, j));
            visited[i - 1][j] = true;
        }

        if (i + 1 < grid.length && grid[i + 1][j] != 0 && !visited[i + 1][j]) {
            deque.push(new GraphCoordinates(i + 1, j));
            visited[i + 1][j] = true;
        }

        if (j - 1 >= 0 && grid[i][j - 1] != 0 && !visited[i][j - 1]) {
            deque.push(new GraphCoordinates(i, j - 1));
            visited[i][j - 1] = true;
        }

        if (j + 1 < grid[0].length && grid[i][j + 1] != 0 && !visited[i][j + 1]) {
            deque.push(new GraphCoordinates(i, j + 1));
            visited[i][j + 1] = true;
        }
    }

    static class GraphCoordinates {
        int x;
        int y;

        public GraphCoordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
