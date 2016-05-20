package com.mystudy.leetcode;


import java.util.HashMap;
import java.util.Map;

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class MaxPointsOnALine {
    public static class Angle {
        int x ; int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Angle angle = (Angle) o;

            if (x != angle.x) return false;
            return y == angle.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        Angle(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public boolean isZero() {
            return x == 0 && y == 0;
        }

    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public Angle cal(Point a, Point b) {
        int dx = a.x - b.x;
        int dy = a.y - b.y;
        if (dx == 0 && dy == 0) {
            return new Angle(0,0);
        }
        else if (dx == 0) {
            return new Angle(0,1);
        }
        else if (dy == 0) {
            return new Angle(1,0);
        }
        else {
            if (dx < 0) {
                dx = -dx;
                dy = -dy;
            }
            int gc = gcd(Math.abs(dx), Math.abs(dy));
            return new Angle(dx/gc, dy/gc);
        }
    }

    public int maxPoints(Point[] points) {
        if (null == points) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int len = points.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            Map<Angle, Integer> map = new HashMap<>();
            int same = 0;
            for (int j = 0; j < len; j ++) {
                Angle angle = cal(points[i], points[j]);
                if (angle.isZero()) {
                    same ++;
                    continue;
                }
                if (map.containsKey(angle)) {
                    map.put(angle, map.get(angle) + 1);
                }
                else {
                    map.put(angle, 1);
                }
            }
            int curMax = 0;
            for (Integer val : map.values()) {
                curMax = Math.max(val, curMax);
            }
            max = Math.max(max, curMax + same);
        }
        return max;
    }
    public static void main(String[] args) {
        //[[0,0],[1,1],[1,-1]]
        Point[] points = {
                new Point(0,0),
                new Point(1,1),
                new Point(0,0),
                new Point(1,1),
                new Point(1, -1)
        };
        System.out.println(new MaxPointsOnALine().maxPoints(points));
    }
}
