package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by tianyuzhi on 17/9/3.
 */
public class FindDuplicateFileInSystem609 {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if (null == paths || paths.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : paths) {
            String[] arr = str.split(" ");
            if (arr.length > 1) {
                String basePath = arr[0];
                for (int i = 1; i < arr.length; i ++) {
                    String[] tmpArr = arr[i].split("\\(");
                    String fileName = tmpArr[0];
                    String content = tmpArr[1];
                    List<String> curFiles = map.getOrDefault(content, new ArrayList<>());
                    curFiles.add(basePath + "/" + fileName);
                    map.put(content, curFiles);
                }
            }
        }
        res.addAll(map.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList()));
        return res;
    }

    public static void main(String[] args) {
        String[] arr = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        System.out.println(new FindDuplicateFileInSystem609().findDuplicate(arr));
    }
}
