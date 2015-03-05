package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yidianadmin on 15-3-5.
 */
public class WordSearch {
    int xDir[] = {0, 1, 0, -1};
    int yDir[] = {1, 0, -1, 0};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {return false;}
        int rows = board.length;
        int cols = board[0].length;
        Set<Integer> visited  = new HashSet<Integer>();
        int[] visitedPos = new int[word.length() + 1];
        char[] wordArray = new char[word.length()];
        word.getChars(0, word.length(), wordArray, 0);
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                int pos = i * cols + j;
                if (board[i][j] == wordArray[0]) {
                    visitedPos[0] = pos;
                    visited.add(pos);
                    if (find(board, visitedPos, 1, visited, wordArray )) {
                        return true;
                    }
                    visited.remove(pos);
                }
            }
        }

        return false;
    }

    public List<Integer> getNextPositions(char[][] board, char ch, Set<Integer> visited, int pos, int rows, int cols) {
        List<Integer> nextPos = new ArrayList<>();
        int curX = pos / cols;
        int curY = pos % cols;
        for (int i = 0; i < 4; i ++) {
            int x = curX + xDir[i];
            int y = curY + yDir[i];
            int po = x * cols + y;
            if (x >=0 && x < rows && y >= 0 && y < cols && po >= 0 && po < rows * cols && !visited.contains(po)) {
                if (board[x][y] == ch) {
                    nextPos.add(po);
                }
            }
        }
        return nextPos;
    }
    public boolean find(char[][] board, int[] visitedPos, int curCount, Set<Integer> visited, char[] word) {
        if (curCount == word.length) {
            return true;
        }
        int rows = board.length;
        int cols = board[0].length;
        List<Integer> nextPos = getNextPositions(board, word[curCount], visited, visitedPos[curCount-1], rows, cols);
        boolean found = false;
        for (int pos : nextPos) {
            visitedPos[curCount] = pos;
            visited.add(pos);
            if (find(board, visitedPos, curCount + 1, visited, word)) {
                found = true;
                break;
            }
            visited.remove(pos);
        }
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "ABCCED"));
        System.out.println(wordSearch.exist(board, "SEE"));
        System.out.println(wordSearch.exist(board, "ABCB"));
    }

}
