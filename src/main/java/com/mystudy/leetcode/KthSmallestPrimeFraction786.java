package com.mystudy.leetcode;

import java.util.ArrayList;

public class KthSmallestPrimeFraction786 {
    class Node {
        public int p;
        public int q;
        public Node(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }

    private int lowerBound(int[] A, double x, int i) {
        int len = A.length;
        if (i + 1 == len) {
            return i;
        }
        if (A[i] > x * A[len-1]) {
            return len;
        }
        int low = i;
        int high = len - 1;
        while (low < high) {
            int mid = low + ((high-low)>>1);
            if (A[i] > A[mid] * x) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }

    private int count(int[] A, double x, Node node) {
        int cnt = 0;
        int len = A.length;
        for (int i = 0; i < A.length; i ++) {
            int j = lowerBound(A, x, i);
            if (j != i && j != len) {
                if (node.q * A[i] > node.p * A[j]) {
                    node.p = A[i];
                    node.q = A[j];
                }
                cnt += len - j;
            }
        }
        return cnt;
    }

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        Node node = new Node(0, 1);
        double low = 0.0;
        double high = 1.0;
        while (true) {
            double mid = (low + high) / 2;
            node.p = 0;
            node.q = 1;
            int cnt = count(A, mid, node);
//            System.out.println(mid + " " + cnt + " " + node.p + " " + node.q);
            if (cnt == K) {
                int[] res = new int[]{node.p, node.q};
                return res;
            }
            else if (cnt > K) {
                high = mid;
            }
            else {
                low = mid;
            }

        }
        //return null;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,5};
        int k = 3;
        int[] res = new KthSmallestPrimeFraction786().kthSmallestPrimeFraction(A, k);
        System.out.println(res[0] + " " + res[1]);
    }
}
