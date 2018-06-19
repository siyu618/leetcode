package com.mystudy.leetcode;

/**
 * Created by tianyuzhi on 18/6/11.
 */
public class ScrambleString87 {
    public boolean isScramble(String s1, String s2) {
        if (null == s1 || null == s2 || s1.length() != s2.length()) {
            return false;
        }
        int len =  s1.length();
        int[][][] matched = new int[len+1][len][len];
        return match(s1, 0, s2, 0, len, matched) == 1;

    }

    private int match(String s1, int i1, String s2, int i2, int len, int[][][] matched) {
        if (matched[len][i1][i2] != 0) {
            return matched[len][i1][i2];
        }
        if (len == 1) {
            matched[1][i1][i2] = s1.charAt(i1) == s2.charAt(i2) ? 1 : -1;
            return matched[len][i1][i2];
        }
        int canMatch = -1;
        for (int k = 1; k < len; k ++) {
            if ((match(s1, i1, s2, i2, k, matched) == 1
                    &&  match(s1, i1+k, s2, i2+k, len-k, matched) == 1)
                ||
                    (match(s1, i1, s2, i2+len-k, k, matched) == 1
                            &&  match(s1, i1+k, s2, i2, len-k, matched) == 1)) {
                canMatch = 1;
                break;
            }
        }
        matched[len][i1][i2] = canMatch;
        return canMatch;
    }

    public boolean isScramble2(String s1, String s2) {
        if (null == s1 || null == s2 || s1.length() != s2.length()) {
            return false;
        }
        int len =  s1.length();
        boolean[][][] matched = new boolean[len+1][len][len];

        for (int subLen = 1; subLen <= len; subLen ++) {
            for (int i = 0; i <= len - subLen; i ++) {
                for (int j = 0; j <= len - subLen; j ++) {
                    if (subLen == 1) {
                        matched[subLen][i][j] = s1.charAt(i) == s2.charAt(j);
                        System.out.printf("subLen = %d, i = %d, j = %d : %b\n", subLen, i, j, matched[subLen][i][j]);
                        continue;
                    }
                    for (int k = 1; k <= subLen - 1; k ++ ) {
                        if (
                                ( matched[k][i][j] && matched[subLen-k][i+k][j+k] )
                                || (matched[k][i][j + subLen -k ] && matched[subLen-k][i + k][j])
                                ) {
                            matched[subLen][i][j] = true;
                            break;
                        }
                    }
                  //  System.out.printf("subLen = %d, i = %d, j = %d : %b\n", subLen, i, j, matched[subLen][i][j]);

                }
            }
        }
        return matched[len][0][0];
    }

    public static void main(String... args) {
        System.out.println( new ScrambleString87().isScramble2("abc", "bca"));
    }
}
