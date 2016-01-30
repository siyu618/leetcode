package com.mystudy.leetcode;

import java.util.*;

/**
 * Created by tianyuzhi on 15/11/24.
 */

//Definition for undirected graph.
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
};

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node, root);
        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            UndirectedGraphNode cur = stack.pop();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.get(cur).neighbors.add(map.get(neighbor));
                }
                else {
                    UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, copy);
                    map.get(cur).neighbors.add(copy);
                    stack.push(neighbor);
                }
            }
        }
        return root;
    }

    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) return null;

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node, root);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.remove();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.get(cur).neighbors.add(map.get(neighbor));
                }
                else {
                    UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, copy);
                    map.get(cur).neighbors.add(copy);
                    queue.add(neighbor);
                }
            }
        }
        return root;
    }


    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if (node == null) return null;

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node, root);
        dfs(node, map);
        return root;
    }

    public void dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map ) {

        for (UndirectedGraphNode item : node.neighbors) {
            if (map.containsKey(item)) {
                map.get(node).neighbors.add(map.get(item));
            }
            else {
                UndirectedGraphNode copy = new UndirectedGraphNode(item.label);
                map.put(item, copy);
                map.get(node).neighbors.add(copy);
                dfs(item, map);
            }
        }
    }
}
