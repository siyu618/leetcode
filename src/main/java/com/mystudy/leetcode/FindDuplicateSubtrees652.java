package com.mystudy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tianyuzhi on 17/8/15.
 */
public class FindDuplicateSubtrees652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<TreeNode, String> map = new HashMap<>();
        List<TreeNode> nodes = new ArrayList<>();
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        buildMap(root, map);
        for (Map.Entry<TreeNode, String> entry : map.entrySet()) {
            String val = entry.getValue();
            TreeNode node = entry.getKey();
            if (!stringIntegerMap.containsKey(val)) {
                stringIntegerMap.put(val, 1);
            }
            else if (1 == stringIntegerMap.get(val)) {
                nodes.add(node);
                stringIntegerMap.put(val, 2);
            }
        }
        return nodes;

    }

    private String buildMap(TreeNode root, Map<TreeNode, String> map) {
        if (root == null) {
            return "#";
        }
        String left = null;
        String right = null;
        if (root.left == null) {
            left = "#";
        }
        else {
            left = buildMap(root.left, map);
        }
        if (root.right == null) {
            right = "#";
        }
        else {
            right = buildMap(root.right, map);
        }
        String str = root.val + "(" + left + ")(" + right + ")";
        map.put(root, str);
        return str;
    }
}
