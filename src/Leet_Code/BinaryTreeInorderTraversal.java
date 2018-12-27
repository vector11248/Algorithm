package Leet_Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-20 19:25
 **/
public class BinaryTreeInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 和前序的区别主要在"根 "与"左" 的访问顺序上。
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){

            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()){
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }


        }
        return result;

    }

}
