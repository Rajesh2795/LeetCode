package classes.Algo;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, newColor, image[sr][sc], visited);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int newColor, int parentColor, boolean[][] visited) {
        if (sr < 0 || sc < 0) return;

        if (sr >= image.length || sc >= image[0].length) return;

        if (visited[sr][sc]) return;

        if (image[sr][sc] != parentColor) return;

        visited[sr][sc] = true;

        dfs(image, sr - 1, sc, newColor, image[sr][sc], visited);
        dfs(image, sr + 1, sc, newColor, image[sr][sc], visited);
        dfs(image, sr, sc - 1, newColor, image[sr][sc], visited);
        dfs(image, sr, sc + 1, newColor, image[sr][sc], visited);

        image[sr][sc] = newColor;
    }
}
