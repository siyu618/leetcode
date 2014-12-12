package com.mystudy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yidianadmin on 14-12-10.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i ++) {
            Set<Character> set = new HashSet<Character>();
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }

        for (int j = 0; j < 9; j ++) {
            Set<Character> set = new HashSet<Character>();
            for (int i = 0; i < 9; i ++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> set = new HashSet<Character>();
                for (int m = i; m < i +3; m ++) {
                    for (int n = j; n < j+3; n++) {
                        if (board[m][n] != '.' && set.contains(board[m][n])) {
                            return false;
                        }
                        set.add(board[m][n]);
                    }
                }
            }
        }
        return true;
    }
}
