package com.mystudy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yidianadmin on 14-12-16.
 */
public class SudokuSolver {
    public static final int MATRIX_SIZE = 9;
    public static final char[] CHARS = "123456789".toCharArray();
    boolean isValid(char[][] board, int i, int j, char toFill) {
        boolean isValid = true;
        int len = board.length;
        //check line
        for (int k = 0; k < len; k++) {
            char ch = board[i][k];
            if (ch != '.' && ch == toFill) {
                return false;
            }
        }
        //check column
        for (int k = 0; k < len; k++) {
            char ch = board[k][j];
            if (ch != '.' && ch == toFill) {
                return false;
            }
        }
        //check block
        int blockI = i / 3;
        int blockJ = j / 3;
        for (int ii = blockI * 3; ii < 3 * (blockI + 1); ii++) {
            for (int jj = blockJ * 3; jj < 3 * (blockJ + 1); jj++) {
                char ch = board[ii][jj];
                if (ch != '.' && ch == toFill) {
                    return false;
                }
            }
        }
        return isValid;
    }

    boolean findSolution(char[][] board, int index) {
        int row = index / MATRIX_SIZE;
        int column = index % MATRIX_SIZE;
        if (row >= MATRIX_SIZE || column >= MATRIX_SIZE) {
            return true;
        }
        char ch = board[row][column];
        if (ch == '.') {
            for (int i = 0; i < CHARS.length; i ++) {
                char toFill = CHARS[i];
                if (isValid(board, row, column, toFill)) {
                    board[row][column] = toFill;
                    if (findSolution(board, index + 1)) {
                        return true;
                    }
                    board[row][column] = '.';

                }
            }
            return false;

        } else {
            return findSolution(board, index+1);
        }
    }


    public void solveSudoku(char[][] board) {
        boolean res = findSolution(board, 0);
        System.out.println("res is " + res);

    }
    public static void main(String[] args) {
        char[][] board = {
                "53..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray(),

        };
        new SudokuSolver().solveSudoku(board);
        for (char[] ch : board) {
            System.out.println(new String(ch));
        }
    }
}
