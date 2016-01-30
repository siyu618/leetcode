package com.mystudy.leetcode;

import java.util.Arrays;

/**
 * Created by tianyuzhi on 15/11/9.
 */
public class HIndex {
    public int hIndex_OK(int[] citations) {
        if (citations == null || citations.length == 0) {return 0;}
        Arrays.sort(citations);
        if (citations[0] >= citations.length) {
            return citations.length;
        }
        int max = 0;
        boolean found = false;
        for (int i = citations.length-1; i >=0; i --) {
            int index = citations.length-i-1;
            if (citations[i] > 0 && citations[i] >= index+1) {
                max = index;
                found =true;
            }
            else {
                break;
            }
        }
        return found ? max +1 : 0;
    }
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {return 0;}
        Arrays.sort(citations);
        if (citations[0] >= citations.length) {
            return citations.length;
        }
        int max = 0;
        boolean found = false;

        int len = citations.length;
        int left = 0;
        int right = citations.length-1;
        int mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            int num = len - mid;
            if (citations[mid] >= num) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        if (citations[left] >= len - left) {return len -left;}
        else return 0;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        int[] citations = {0,1};//{/{3, 0, 6, 1, 5};
        System.out.println(hIndex.hIndex(citations));
        return;
    }
}
