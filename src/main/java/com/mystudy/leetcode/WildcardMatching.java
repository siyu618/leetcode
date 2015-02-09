package com.mystudy.leetcode;

/**
 * Created by yidianadmin on 15-1-28.
 */
public class WildcardMatching {
    public static boolean isMatch(String s, int sStart, String p, int pStart, boolean[][] matched, boolean[][] visited) {
        if (visited[sStart][pStart]) {return matched[sStart][pStart];}
        int finished = 0;
        if (sStart == s.length()) {finished++;}
        if (pStart == p.length()) {finished ++;}
        if (finished  == 2 ) {
            visited[sStart][pStart] = true;
            matched[sStart][pStart] = true;
            return true;}
        if (sStart == s.length()) {
            boolean match  = false;
            if (p.charAt(pStart) == '*') {
                int i = pStart;
                while (i < p.length() && p.charAt(i) == '*') { i ++; }
                if (i == p.length()) match = true;
                else {match = false;}
            }
            else match = false;
            visited[sStart][pStart] = true;
            matched[sStart][pStart] = match;
            return match;
        }
        if (finished == 1 && sStart != s.length()) {
            visited[sStart][pStart] = true;
            matched[sStart][pStart] = false;
            return matched[sStart][pStart];}

        if (p.charAt(pStart) == '?' || s.charAt(sStart) == p.charAt(pStart)) {
            matched[sStart][pStart] = isMatch(s, sStart+1, p, pStart+1, matched, visited);
            visited[sStart][pStart] = true;
            return matched[sStart][pStart];

        } else if (p.charAt(pStart) == '*') {
            matched[sStart][pStart] = isMatch(s, sStart, p, pStart+1, matched, visited) || isMatch(s, sStart+1, p, pStart, matched, visited);
            visited[sStart][pStart] = true;
            return matched[sStart][pStart];
        } else {
            matched[sStart][pStart] = false;
            visited[sStart][pStart] = true;
            return matched[sStart][pStart];
        }

    }

    public static boolean isMatch(String s, String p) {
        if (s == null && p == null) { return true;}
        if ((s== null && p != null) ||(s!= null && p == null)) { return false;}
        int starCount = 0;
        for (Byte c : p.getBytes()) {
            if (c == '*') starCount ++;
        }
        if (p.length() - starCount > s.length()) return false;
        boolean[][] matched = new boolean[s.length()+1][p.length()+1];
        boolean[][] visited = new boolean[s.length()+1][p.length()+1];

        for (int i = 0; i <= s.length(); i ++) {
            for (int j = 0; j <= p.length(); j ++) {
                matched[i][j] = false;
                visited[i][j] = false;
            }
        }
        //for (int i = 0; i <= s.length(); i ++) {matched[i][p.length()] = true;visited[i][p.length()] = true;}
        //for (int j = 0; j <= p.length(); j ++) {matched[s.length()][j] = true;visited[s.length()][j] = true;}

        return isMatch(s, 0, p, 0, matched, visited);
    }

    public static boolean isMatch2(String s, int sStart, String p, int pStart) {
        if (s == null && p == null) { return true;}
        if ((s== null && p != null) ||(s!= null && p == null)) { return false;}
        int finished = 0;
        if (sStart == s.length()) {finished++;}
        if (pStart == p.length()) {finished ++;}
        if (finished  == 2 ) {return true;}
        if (sStart == s.length()) {
            if (p.charAt(pStart) == '*') {
               int i = pStart;
               while (i < p.length() && p.charAt(i) == '*') { i ++; }
               if (i == p.length()) return true;
                else {return false;}
            }
            else return false;
        }
        if (finished == 1 && sStart != s.length()) {return false;}

        if (p.charAt(pStart) == '?' || s.charAt(sStart) == p.charAt(pStart)) {
            return isMatch2(s, sStart+1, p, pStart+1);
        } else if (p.charAt(pStart) == '*') {
            return isMatch2(s, sStart, p, pStart+1) || isMatch2(s, sStart+1, p, pStart);
        } else {
            return false;
        }

    }

    public static boolean isMatch2(String s, String p) {
        return isMatch2(s, 0, p, 0);
    }

    public static boolean isMatch3(String s, String p) {
        if (s == null && p == null) { return true;}
        if ((s== null && p != null) ||(s!= null && p == null)) { return false;}
        int starCount = 0;
        for (Byte c : p.getBytes()) {
            if (c == '*') starCount ++;
        }
        if (p.length() - starCount > s.length()) return false;
        boolean[][] matched = new boolean[s.length()+1][p.length()+1];
        int lenS = s.length();
        int lenP = p.length();

        matched[0][0] = true;
        for (int j = 1; j <= lenP; j ++) {
            matched[0][j] = matched[0][j-1] && p.charAt(j-1) == '*';
        }
        byte[] bs = s.getBytes();
        byte[] bp = p.getBytes();

        for (int i = 1; i <= lenS; i ++) {
            for (int j = 1; j <= lenP; j ++) {
                if (bp[j-1] == '*') {
                    matched[i][j] = matched[i-1][j] || matched[i][j-1];
                } else {
                    matched[i][j] = matched[i-1][j-1] && (bs[i-1] == bp[j-1] || bp[j-1] == '?');
                }
            }
        }
        return matched[s.length()][p.length()];
    }


    public static void main(String[] args) {
        System.out.println(WildcardMatching.isMatch3("aa","a") );
        System.out.println(WildcardMatching.isMatch3("aa","aa") );
        System.out.println(WildcardMatching.isMatch3("aa","aaa") );
        System.out.println(WildcardMatching.isMatch3("aa", "*") );
        System.out.println(WildcardMatching.isMatch3("aa", "a*") );
        System.out.println(WildcardMatching.isMatch3("ab", "?*") );
        System.out.println(WildcardMatching.isMatch3("aab", "c*a*b") );
    }
}
