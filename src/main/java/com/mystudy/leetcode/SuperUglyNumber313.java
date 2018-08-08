package com.mystudy.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by tianyuzhi on 18/8/8.
 */
public class SuperUglyNumber313 {
    public static class Struct {
        int primesIndex;
        int nextPos;
        int nextValue;
        public Struct(int primesIndex, int nextPos, int nextValue) {
            this.primesIndex = primesIndex;
            this.nextPos = nextPos;
            this.nextValue = nextValue;
        }
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Struct> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.nextValue));
        int[] res = new int[n+1];
        res[1] = 1;
        for (int i = 0; i < primes.length; i ++) {
            priorityQueue.add(new Struct(i, 1, primes[i] * res[1]));
        }
        for (int i = 2; i <= n; i ++) {
            Struct cur = priorityQueue.peek();
            res[i] = cur.nextValue;
            Struct next;
            while (priorityQueue.peek().nextValue == cur.nextValue) {
                next = priorityQueue.poll();
                Struct nNext = new Struct(next.primesIndex, next.nextPos + 1, res[next.nextPos+1] * primes[next.primesIndex]);
                priorityQueue.add(nNext);
            }
        }
        return res[n];
    }

    public int nthSuperUglyNumber2(int n, int[] primes) {
        PriorityQueue<Struct> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.nextValue));
        int[] res = new int[n+1];
        res[1] = 1;
        int curMax = 1;
        for (int i = 0; i < primes.length; i ++) {
            priorityQueue.add(new Struct(i, 1, primes[i] * res[1]));
        }
        for (int i = 2; i <= n; i ++) {
            while (true) {
                Struct next = priorityQueue.poll();
                Struct nNext = new Struct(next.primesIndex, next.nextPos + 1, res[next.nextPos+1] * primes[next.primesIndex]);
                priorityQueue.add(nNext);
                if (next.nextValue > curMax) {
                    res[i] = next.nextValue;
                    curMax = res[i];
                    break;
                }
            }
        }
        return res[n];
    }

    public static void main(String...args) {
        int[] arr = {2,7,13,19};
        System.out.println(new SuperUglyNumber313().nthSuperUglyNumber(12, arr
        ));
    }


}
