package com.mystudy.leetcode;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yidianadmin on 15-2-4.
 */
public class N_QueensII {
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

    public void search(int[] pos, int index, List<Integer> res) {
        if (index == pos.length) {
            res.add(1);
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

    public int totalNQueens(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if (n <= 0) {
            return 0;
        }
        int[] pos = new int[n];
        int index = 0;
        search(pos, index, res);
        return res.size();

    }
    public static void main(String[] args) {
        N_QueensII n_queens = new N_QueensII();
        System.out.println(n_queens.totalNQueens(4));
    }
}
