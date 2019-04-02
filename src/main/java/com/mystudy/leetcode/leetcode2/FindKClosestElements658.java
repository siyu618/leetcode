package com.mystudy.leetcode.leetcode2;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements658 {
    private int lowerBound(int[] arr, int target) {
        if (arr[0] >= target) {
            return 0;
        }
        if (arr[arr.length-1] <= target) {
            return arr.length - 1;
        }
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            int mid = left + ((right - left)>>1);
            int fx = arr[mid] - target;
            if (fx >= 0) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }


    private int upBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            int fx = arr[mid] - target;
            if (fx <= 0) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (null == arr || arr.length < 1) {
            return new ArrayList<>(0);
        }

        int lowerBound = upBound(arr, x);
        int left = lowerBound;
        int right = left+1;
        int len = arr.length;
        List<Integer> leftRes = new ArrayList<>(len);
        List<Integer> rightRes = new ArrayList<>(len);

        while (k > 0) {
            int curLeft = left >= 0 ? Math.abs(x - arr[left]) : Integer.MAX_VALUE ;
            int curRight = right < arr.length ? Math.abs(x - arr[right]) : Integer.MAX_VALUE ;
            if (curLeft == Integer.MAX_VALUE && curRight == Integer.MAX_VALUE) {
                break;
            }
            if (curLeft <= curRight) {
                int tmp = arr[left];
                while (k > 0 && left >= 0 && arr[left] == tmp) {
                    leftRes.add(arr[left]);
                    left --;
                    k --;
                }
            }
            else {
                rightRes.add(arr[right]);
                right ++;
                k --;
            }
        }
        List<Integer> res = new ArrayList<>(leftRes.size() + rightRes.size());
        for (int i = leftRes.size()-1; i >= 0; i --) {
            res.add(leftRes.get(i));
        }
        for (int num : rightRes) {
            res.add(num);
        }
        return res;
    }

    public static void main(String[] args) {
        FindKClosestElements658 test = new FindKClosestElements658();
        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        // [0,0,1,2,3,3,4,7,7,8]
        //3
        //5
        int k = 3;
        int x = 5;
        System.out.println(test.findClosestElements(arr, k, x));
    }
}
