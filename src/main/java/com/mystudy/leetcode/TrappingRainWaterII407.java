package com.mystudy.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by tianyuzhi on 18/6/19.
 */
public class TrappingRainWaterII407 {
    static class Point{
        public int row;
        public int col;
        public int height;
        public Point(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    private boolean isBoard(int i , int j, int rowN, int colN) {
        return (i == 0 || i == rowN-1 || j == 0 || j == colN - 1);
    }
    public int trapRainWater(int[][] heightMap) {
        if (null == heightMap || heightMap.length == 0 || heightMap[0].length == 0){
            return 0;
        }
        int rowN = heightMap.length;
        int colN = heightMap[0].length;
        boolean[][] visited = new boolean[rowN][colN];
        PriorityQueue<Point> queue = new PriorityQueue<>(rowN * colN, (a, b) -> a.height - b.height);
        int[][] directions = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        for (int i = 0; i < rowN; i ++ ) {
            for (int j = 0; j < colN; j ++) {
                if (isBoard(i, j, rowN, colN)){
                    queue.offer(new Point(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        int res = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int curX = cur.row;
            int curY = cur.col;
            int curHeight = cur.height;

            for (int i = 0; i < 4; i ++){
                int nX = curX + directions[i][0];
                int nY = curY + directions[i][1];
                if (nX >= 0 && nX < rowN && nY >= 0 && nY < colN && !visited[nX][nY]) {
                    visited[nX][nY] = true;
                    res += Math.max(0, curHeight - heightMap[nX][nY]);
                    queue.offer(new Point(nX, nY, Math.max(heightMap[nX][nY], curHeight)));
                }
            }
        }
        return res;

    }
    public static void main(String... args) {
        int[][] matrix = new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        System.out.println(new TrappingRainWaterII407().trapRainWater(matrix));
    }
}
