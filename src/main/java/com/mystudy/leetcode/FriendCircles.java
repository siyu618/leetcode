package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 17/5/25.
 */
public class FriendCircles {
    int total;
    public int getRoot(int[] parent, int i) {
        int root = i;
        while (parent[root] != root) {
            root = parent[root];
        }
        return root;
    }
    public void merge(int[] parent, int i, int j) {
        if (i == j) {return;}
        int rootI = getRoot(parent, i);
        int rootJ = getRoot(parent, j);
        if (rootI != rootJ) {
            parent[rootJ] = rootI;
            total -= 1;
             int cur = j;
             while (parent[cur] != cur) {
                 parent[cur] = rootI;
                 cur = parent[cur];
             }
        }

    }

    public int findCircleNum(int[][] M) {
        if (null == M || M.length == 0 || null == M[0] || M[0].length == 0) {
            return 0;
        }
        int len = M.length;
        total = len;

        int[] tree = new int[len];
        for (int i = 0; i < len; i ++) {
            tree[i] = i;
        }
        for (int i = 0; i < len; i ++) {
            for (int j = 0; j < i; j ++) {
                if (M[i][j] == 1) {
                    merge(tree, i, j);
                }
            }
        }
        return total;

    }

    public static void main(String[] args) {
        int[][] M = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(new FriendCircles().findCircleNum(M));

    }
}
