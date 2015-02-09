package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by yidianadmin on 15-1-31.
 */
public class Anagrams {
    public String sortString(String str) {
        byte[] bytes = str.getBytes();
        Arrays.sort(bytes);
        return new String(bytes);
    }

    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        Map<String, Integer> strDict = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length; i ++) {
            String str = strs[i];
            String tmp = sortString(str);
            if (!strDict.containsKey(tmp)) {
                strDict.put(tmp, i);
            }
            else {
                int val = (int)strDict.get(tmp);
                if (val == -1) {
                    res.add(strs[i]);
                }else {
                    res.add(strs[val]);
                    res.add(strs[i]);
                    strDict.put(tmp, -1);
                }
            }
        }
        return res;
    }
}
