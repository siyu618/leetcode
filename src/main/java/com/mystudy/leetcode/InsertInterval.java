package com.mystudy.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yidianadmin on 15-2-5.
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }
        List<Interval> res = new LinkedList<Interval>();
        boolean finish = false;
        for (Interval interval : intervals) {
            if (finish) {
                res.add(interval);
                continue;
            }
            if (interval.start > newInterval.end) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
                finish = true;
            } else if (interval.end < newInterval.start) {
                res.add(interval);
                continue;
            }
            else {
                newInterval = new Interval(Math.min(interval.start, newInterval.start),
                        Math.max(interval.end, newInterval.end));
            }
        }
        if (null != newInterval) {
            res.add(newInterval);
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] start = {1,3,6,8,12};
        int[] end = {2,5,7,10,16};
        int n = start.length;
        List<Interval> list = new LinkedList<Interval>();
        for (int i = 0; i < n; i ++) {
            list.add(new Interval(start[i], end[i]));
        }
        Interval newInterval = new Interval(4,9);
        List<Interval> newList = new InsertInterval().insert(list, newInterval);
        for (Interval interval : newList) {
            System.out.println(interval.start + " " + interval.end);
        }
    }
}
