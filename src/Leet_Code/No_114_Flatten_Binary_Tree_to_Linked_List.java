package Leet_Code;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-21 21:17
 **/
public class No_114_Flatten_Binary_Tree_to_Linked_List {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {

        // 一颗二叉树，转成前序遍历的链表。
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){

            TreeNode cur = stack.pop();

            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
            cur.left = null;
            if (!stack.isEmpty()){
                cur.right = stack.peek();
            }
        }

    }


}
