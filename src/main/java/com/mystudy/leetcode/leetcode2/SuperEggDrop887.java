package com.mystudy.leetcode.leetcode2;

public class SuperEggDrop887 {

    public int superEggDrop(int K, int N) {
        int[] dp = new int[K+1];
        // https://www.acwing.com/solution/leetcode/content/579/
        //f(i,j) 表示 进行 i 此移动，有 j 个鸡蛋，最多可以检查楼层的高度
        // f(1,0) = 0; f(1, j) = 1 ,j >= 1
        // f(i,j) = f(i-1,j-1) + f(i-1,j) + 1
        int res = 0;
        while (dp[K] < N) {
            for (int i = K; i >= 1; i --) {
                dp[i] = dp[i] + dp[i-1] + 1;
            }
            res ++;
        }
        return res;

    }


    public int superEggDrop2(int K, int N) {
        int[][] dp = new int[K+1][N+1];

        for (int j = 1; j <= N; j ++) {
            dp[1][j] = j;
        }
        for (int i = 1; i <= K; i ++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int i = 2; i <= K; i ++) {
            for (int j = 1; j <= N; j ++) {
                dp[i][j] = j;
                for (int k = 1; k < j; k ++) {
                    dp[i][j] = Math.min(dp[i][j],
                            Math.max(dp[i-1][k-1] + 1, dp[i][j-k] + 1));
                }
            }
        }
        return dp[K][N];
    }

    public static void main(String... args) {
        int[][] pairs = {{1,2},{2,6},{3,14},{2,100}};
        for (int[] pair : pairs) {
            System.out.println(new SuperEggDrop887().superEggDrop2(pair[0], pair[1]));
        }
        for (int[] pair : pairs) {
            System.out.println(new SuperEggDrop887().superEggDrop(pair[0], pair[1]));
        }
    }
}
