package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 14-12-14.
 */
public class NextPermutation {
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
            int j = i+1;
            for (;j+1<num.length && num[i] < num[j+1]; j ++) {
                // TODO: can be done by binary search
            }
            swap(num, i, j);
        }
        reverse(num, i+1, num.length-1);
    }

    public static void  main(String[] args) {
        int arr[] = {1,3,5,4,2};
        new NextPermutation().nextPermutation(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
