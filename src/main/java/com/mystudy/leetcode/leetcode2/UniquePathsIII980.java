package com.mystudy.leetcode.leetcode2;

public class UniquePathsIII980 {

    class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isTheSame(Point other) {
            return other.x == x && other.y == y;
        }
    }
    public int uniquePathsIII(int[][] grid) {
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length + 2;
        int col = grid[0].length + 2;
        Point start = null;
        Point end = null;
        int[][] aGrid = new int[row][col];
        int total = 0;
        for (int i = 0; i < row; i ++ ) {
            for (int j = 0; j < col; j ++) {
                if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                    aGrid[i][j] = -1;
                }
                else {
                    aGrid[i][j] = grid[i-1][j-1];
                    if (aGrid[i][j] == 1) {
                        start = new Point(i, j);
                    }
                    else if (aGrid[i][j] == 2) {
                        end = new Point(i, j);
                    }
                    if (aGrid[i][j] != -1) {
                        total ++;
                    }
                }
            }
        }
        int[] res = new int[1];
        boolean[][] visited = new boolean[row][col];
        visited[start.x][start.y] = true;
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        dfs(start, end, aGrid, visited, res,directions, total, 1);
        return res[0];
    }

    private void dfs(Point start, Point end, int[][] grid, boolean[][] visited, int[] res, int[][] directions, int total, int depth) {
        if (depth == total || start.isTheSame(end)) {
            if (start.isTheSame(end)) {
                res[0] ++;
            }
            return;
        }
        for (int i = 0; i < directions.length; i ++) {
            int nx = start.x + directions[i][0];
            int ny = start.y + directions[i][1];
            if (grid[nx][ny] != -1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(new Point(nx, ny), end, grid, visited, res, directions, total, depth + 1);
                visited[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) {
        int [][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        System.out.println(new UniquePathsIII980().uniquePathsIII(grid));
    }
}
