package com.graphs.bfsDfs;

public class FloodFillAlgorithm {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rowSize = image.length;
        int colSize = image[0].length;

        int prevColor = image[sr][sc];
        if (prevColor == color) {
            return image;
        }
        dfs(image, sr, sc, color, prevColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int prevColor) {
        if (image[sr][sc] != prevColor) {
            return;
        }

        image[sr][sc] = color;

        // now do dfs in all 4 direction

        int rowSize = image.length;
        int colSize = image[0].length;

        if (sr - 1 >= 0) {
            dfs(image, sr - 1, sc, color, prevColor);
        }
        if (sc + 1 < colSize) {
            dfs(image, sr, sc + 1, color, prevColor);
        }
        if (sr + 1 < rowSize) {
            dfs(image, sr + 1, sc, color, prevColor);

        }
        if (sc - 1 >= 0) {
            dfs(image, sr, sc - 1, color, prevColor);
        }
    }
}
