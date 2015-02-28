package com.mystudy.leetcode;

import java.util.Stack;

/**
 * Created by yidianadmin on 15-2-12.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null) {
            return path;
        }
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String str : arr) {
            if (str.isEmpty() || str.equals(".")) {
                continue;
            }
            else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(str);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            String str = stack.pop();
            if (res.isEmpty()) {
                res = str;
            }
            else {
                res = str + "/" + res;
            }
        }

        res = "/" + res;
        return res;

    }

    public static void main(String[] args) {
        String[] arr =  {"/abc/...", "/..", "/home/abc", "/a/./b/../../c/"};
        for (String str : arr) {
            System.out.println(new SimplifyPath().simplifyPath(str));
        }
    }
}
