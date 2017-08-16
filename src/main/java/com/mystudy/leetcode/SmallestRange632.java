package com.mystudy.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by tianyuzhi on 17/8/1.
 */
public class SmallestRange632 {

    class Node {
        int val;
        int row;
        int col;

        public Node(int val, int row, int col) {
           this.val = val;
           this.row = row;
           this.col = col;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(nums.size(), Comparator.comparingInt(o -> o.val));


        int max = nums.get(0).get(0);

        for (int row = 0; row < nums.size(); row++) {
            int cur = nums.get(row).get(0);
            max = Math.max(max, cur);
            priorityQueue.add(new Node(cur, row, 0));

        }

        int range = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while (true) {
            Node curNode = priorityQueue.poll();
            int cur = curNode.val;
            int min = cur;
            max = Math.max(max, cur);

            if (range > max - min + 1) {
                range = max - min + 1;
                start = min;
                end = max;
            }

            if (curNode.col + 1 < nums.get(curNode.row).size()) {
                cur = nums.get(curNode.row).get(curNode.col + 1);
                max = Math.max(max, cur);
                priorityQueue.add(new Node(cur, curNode.row, curNode.col+1));
            }
            else {
                break;
            }
        }
        int[] res = {start, end};
        return res;
    }
}
