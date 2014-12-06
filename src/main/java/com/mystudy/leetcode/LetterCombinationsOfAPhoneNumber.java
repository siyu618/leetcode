package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yidianadmin on 14-12-4.
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.isEmpty()) {
            res.add("");
            return res;
        }
        StringBuilder sb = new StringBuilder();
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        genCombinations(digits, 0, sb, res, map);
        return res;

    }

    public void genCombinations(String digits, int index, StringBuilder sb,  List<String> res, String[] map) {
        if (index == digits.length()){
            res.add(sb.toString());
            return;
        }
        int in = digits.charAt(index) - '0';
        String str = map[in];
        for (int i = 0; i < str.length(); i ++) {
            char ch = str.charAt(i);
            sb.append(ch);
            genCombinations(digits, index + 1, sb, res, map);
            sb.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        List<String> res = new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
        for (String str : res) {
            System.out.println(str);
        }
    }
}
