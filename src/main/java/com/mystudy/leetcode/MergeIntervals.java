package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by yidianadmin on 14-12-14.
 */

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
             return new ArrayList<Interval>();
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> res = new ArrayList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval item : intervals) {
            if (item.start > end) {
                res.add(new Interval(start, end));
                start = item.start;
                end = item.end;
            }
            else {
                end = Math.max(end, item.end);
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(1,3));
        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list.add(new Interval(15,18));
        List<Interval> res = new MergeIntervals().merge(list);
        for (Interval item : res) {
            System.out.println("[" + item.start + "," + item.end + "]");
        }
        System.out.println();
    }
}
