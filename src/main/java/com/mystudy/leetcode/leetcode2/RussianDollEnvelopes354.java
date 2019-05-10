package com.mystudy.leetcode.leetcode2;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes354 {
    public class Node {
        public int x;
        public int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        if (null == envelopes || envelopes.length == 0) {
            return 0;
        }
        int len = envelopes.length;
        Node[] nodes = new Node[len];

        for (int i = 0; i < len; i ++) {
            nodes[i] = new Node(envelopes[i][0], envelopes[i][1]);
        }

        Arrays.sort(nodes, Comparator.comparingInt(o -> o.x));

        int[] dp = new int[len];
        for (int i = 0; i < len; i ++) {
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 0; i < len; i ++) {
            for (int j = i + 1; j < len; j ++) {
                if (nodes[i].x < nodes[j].x && nodes[i].y < nodes[j].y) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;

    }

    public static void main(String... args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(new RussianDollEnvelopes354().maxEnvelopes(envelopes));
    }
}
