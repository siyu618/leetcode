package com.mystudy.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yidianadmin on 15-2-4.
 */
public class N_Queens {
    boolean isValid(int[] pos, int index, int next) {
        int x = next / pos.length;
        int y = next % pos.length;
        for (int i = 0; i < index; i ++ ) {
            int px = pos[i] / pos.length;
            int py = pos[i]% pos.length;
            if (px == x || y == py || Math.abs(x-px) == Math.abs(y-py)) {
                return false;
            }
        }
        return true;
    }

    public String[] buildMatrix(int[] pos) {
        int n = pos.length;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                board[i][j] = '.';
            }
        }
        for (int i : pos) {
            int px = i / n;
            int py = i % n;
            board[px][py] = 'Q';
        }
        String[] ma = new String[n];
        for (int i = 0; i < n; i ++) {
            ma[i] = new String(board[i]);
        }
        return ma;
    }

    public void search(int[] pos, int index, List<String[]> res) {
        if (index == pos.length) {
            res.add(buildMatrix(pos));
            return;
        }
        int start = pos.length * index;
        int end = pos.length * (index + 1);
        for (int i = start; i < end; i ++) {
            if (isValid(pos, index, i)) {
                pos[index] = i;
                search(pos, index+1, res);
            }
        }
    }


    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new LinkedList<String[]>();
        if (n <= 0) {
            return res;
        }
        int[] pos = new int[n];
        int index = 0;
        search(pos, index, res);
        return res;

    }
    public static void main(String[] args) {
        N_Queens n_queens = new N_Queens();
        List<String[]> res = n_queens.solveNQueens(4);
        for (String[] arr: res) {
            for (String str : arr) {
                System.out.println(str);
            }
            System.out.println();
        }
    }
}
