package com.mystudy.leetcode.leetcode2;

import java.util.PriorityQueue;

public class LastStoneWeight1046 {
    public int lastStoneWeight(int[] stones) {
        if (null == stones || stones.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, (a, b)->b-a);
        for (int num: stones) {
            queue.offer(num);
        }

        while (queue.size() >= 2) {
            int a = queue.poll();
            int b = queue.poll();
            if (a == b) {
                continue;
            }
            else {
                queue.offer(Math.abs(a-b));
            }
        }
        if (queue.size() == 0) {
            return 0;
        }
        else {
            return queue.poll();
        }
    }

    public static void main(String... args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(new LastStoneWeight1046().lastStoneWeight(stones));
    }
}
