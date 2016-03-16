package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yidianadmin on 15-3-11.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (null == A || A.length == 0) {
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        int resCount=1;
        int curNumCount = 1;
        int curNum = A[0];
        res.add(curNum);
        for (int i = 1; i < A.length; i ++) {
            if (A[i] == curNum) {
                if (curNumCount < 2) {

                    A[resCount ++] = curNum;
                }
                curNumCount ++;
            }
            else {
                curNum = A[i];
                curNumCount = 1;
                A[resCount ++] = curNum;

            }
        }
        return resCount;

    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();
        System.out.println(removeDuplicatesFromSortedArrayII.removeDuplicates(arr));
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
