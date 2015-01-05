package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by yidianadmin on 14-12-17.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashMap<Integer, List<List<Integer>>> res = new HashMap<Integer, List<List<Integer>>>();
        res.put(0, new ArrayList<List<Integer>>());
        for (int i = 1; i <= target; i ++) {
            if (!res.containsKey(i)) {
                res.put(i, new ArrayList<List<Integer>>());
            }
            for (int candidate : candidates) {
                int tmp = i - candidate;
                if (tmp < 0) {break;}
                else if (tmp == 0){
                    List<List<Integer>> cur = res.get(i);
                    List<Integer> tmpList = new LinkedList<Integer>();
                    tmpList.add(i);
                    cur.add(tmpList);
                }
                else {
                    List<List<Integer>> pres = res.get(tmp);
                    List<List<Integer>> cur = res.get(i);

                    for (List<Integer> list : pres) {
                        if (candidate < list.get(list.size()-1)) {
                            continue;
                        }
                        List<Integer> tmpList = new LinkedList<Integer>(list);
                        tmpList.add(candidate);
                        cur.add(tmpList);
                    }
                }
            }
        }
        return res.get(target);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> cur = new LinkedList<Integer>();
        search(candidates, 0, target, cur, res);
        return res;

    }

    public void search(int[] candidates, int index, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<Integer>(cur));
        }
        if (index >= candidates.length || target < 0) {
            return;
        }
        if (target < candidates[index]) {
            return;
        }
        if (candidates[index] <= target) {
            cur.add(candidates[index]);
            search(candidates, index, target - candidates[index], cur, res);
            cur.remove(cur.size()-1);
        }
        search(candidates, index+1, target, cur, res);

    }

    public static void main(String[] args) {
        int[] num = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = new CombinationSum().combinationSum2(num, target);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
