package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by tianyuzhi on 16/5/18.
 */
public class TopKFrequentElements {
    public static class Pair {
        Integer num;
        Integer count;
        public Pair(Integer num,  Integer count) {
            this.num = num;
            this.count = count;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || k ==0 ) return new ArrayList(0);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num)+1);
            }
            else {
                countMap.put(num, 1);
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);
        for (Integer item : countMap.keySet()) {
            Pair pair = new Pair(item, countMap.get(item));
            if (queue.size() < k) {
                queue.add(pair);
            } else {
                if (queue.peek().count < pair.count) {
                    queue.poll();
                    queue.add(pair);
                }

            }
        }
        List<Integer> res = new ArrayList<>(queue.size());
        while (!queue.isEmpty()) {
            res.add(queue.poll().num);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int k = 2;
        TopKFrequentElements test = new TopKFrequentElements();
        System.out.println(test.topKFrequent(arr, k));
    }
}
