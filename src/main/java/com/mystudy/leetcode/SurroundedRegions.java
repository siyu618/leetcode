package com.mystudy.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tianyuzhi on 15/11/15.
 */
public class SurroundedRegions {
    public static class Pair { public int x; public int y; public Pair(int x, int y) {this.x = x; this.y = y;}}
    public void solve(char[][] board) {
        if (null == board || board.length == 0 || board[0].length == 0) return;
        int rowNum = board.length;
        int colNum = board[0].length;
        boolean[][] visited = new boolean[rowNum][colNum];
        int[] dirx = {0,1,0,-1};
        int[] diry = {1,0,-1,0};
        Queue<Pair> queue = new LinkedList<>();

        char[][] newBoard = new char[rowNum][colNum];
        for (int i = 0; i < rowNum; i ++) {
            for (int j = 0; j < colNum; j ++) {
                newBoard[i][j] = 'X';
            }
        }
        for (int i = 0; i < rowNum; i ++) {
            if (board[i][0] == 'O') {
                queue.add(new Pair(i, 0));
                newBoard[i][0] = 'O';
            }
            visited[i][0] = true;
            if (board[i][colNum-1] == 'O') {
                queue.add(new Pair(i, colNum -1));
                newBoard[i][colNum-1] = 'O';
            }
            visited[i][colNum-1] = true;
        }

        for (int j = 1; j < colNum; j ++) {
            if (board[0][j] == 'O') {
                queue.add(new Pair(0,j));
                newBoard[0][j] = 'O';
            }
            visited[0][j] = true;
            if (board[rowNum-1][j] == 'O') {
                queue.add(new Pair(rowNum-1, j));
                newBoard[rowNum-1][j] = 'O';
            }
            visited[rowNum-1][j] = true;
        }
        while (!queue.isEmpty()) {
            Pair cur = queue.remove();
            for (int i = 0; i < 4; i ++) {
                int nx = cur.x + dirx[i];
                int ny = cur.y + diry[i];
                if (nx >= 0 && nx < rowNum && ny >= 0 && ny < colNum && !visited[nx][ny] && board[nx][ny] == 'O') {
                    newBoard[nx][ny] = 'O';
                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
        for (int i = 0; i < rowNum; i ++) {
            for (int j = 0; j < colNum; j ++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] board = {{'X','X','X'},{'X','O','X'}, {'X','X','X'}};
        surroundedRegions.solve(board);
        for (int i = 0; i < board.length; i ++) {
            System.out.println(board[i]);
        }
    }
}
