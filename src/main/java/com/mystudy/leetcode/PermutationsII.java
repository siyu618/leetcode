package com.mystudy.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yidianadmin on 14-12-17.
 */
public class PermutationsII {
    public void swap(int[]num, int i, int j) {
        int tmp = num[j];
        num[j] = num[i];
        num[i] = tmp;
    }
    public void reverse(int[] num, int left, int right) {
        while (left<right) {
            swap(num, left, right);
            left ++;
            right --;
        }
    }

    public void nextPermutation(int[] num) {
        int i = num.length-2;
        for (; i>=0 && num[i] >= num[i+1]; i --) {
            ;;
        }
        if (i>=0) {
            int j = i + 1;
            for (; j + 1 < num.length && num[i] < num[j + 1]; j++) {
                // TODO: can be done by binary search
            }
            swap(num, i, j);
            reverse(num, i + 1, num.length - 1);
        }
    }

    public boolean hasNextPermutation(int[] num) {
        int i = num.length-2;
        for (; i>=0 && num[i] >= num[i+1]; i --) {
            ;;
        }
        if (i>=0) {
            return true;
        }
        return false;
    }

    public List<Integer> arrayToList(int[] num) {
        List<Integer> res = new LinkedList<Integer>();
        for (int i : num) {
            res.add(i);
        }
        return res;
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        res.add(arrayToList(num));
        while (hasNextPermutation(num)) {
            nextPermutation(num);
            res.add(arrayToList(num));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {1, 1, 3};
        List<List<Integer>> res = new PermutationsII().permuteUnique(num);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();

        }
    }
}
