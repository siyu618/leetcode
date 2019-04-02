package com.mystudy.leetcode;

import java.util.*;

public class FindKPairsWithSmallestSums373 {
    class Node {
        public int x;
        public int y;
        public int val;
        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null) {
            return new ArrayList<>(0);
        }
        List<int[]> res = new ArrayList<>(k);
        Set<Integer> done = new HashSet<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        int len1 = nums1.length;
        int len2 = nums2.length;

        queue.add(new Node(0, 0, nums1[0] + nums2[0]));
        while (k -- > 0) {
            Node cur = queue.poll();
            done.add(cur.x * nums2.length + cur.y);
            int[] curRes = {cur.x, cur.y};
            res.add(curRes);

            if (cur.x < len1) {
                int tm = (cur.x + 1) * len2 + cur.y;
                if (!done.contains(tm)) {
                    queue.add(new Node(cur.x + 1, cur.y, nums1[cur.x + 1] + nums2[cur.y]));
                }

            }
            if (cur.y < len2) {
                int tm = cur.x * len2 + cur.y + 1;
                if (!done.contains(tm)) {
                    queue.add(new Node(cur.x, cur.y+1, nums1[cur.x] + nums2[cur.y+1]));
                }
            }
        }
        return res;


    }
}
