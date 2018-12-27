package Leet_Code;

import java.util.HashSet;
import java.util.Stack;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-22 19:23
 **/
public class No_129_Sum_Root_to_Leaf_Numbers {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>(); // set 用于判断根节点是否是第一次被访问。
        stack.push(root);
        int total_sum = 0;
        int sub_sum = 0;
        TreeNode cur = root;
        while (!stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                sub_sum = sub_sum * 10 + cur.val;
                cur = cur.left;
            }
            if (!stack.isEmpty()){
                cur = stack.pop();
                // 判断该根节点是否被访问过。
                if (set.contains(cur)){
                    sub_sum = (sub_sum-cur.val) / 10;
                    cur = null;
                }else {
                    set.add(cur);
                    if (cur.right == null && cur.left == null){
                        // 叶子节点
                        total_sum += sub_sum;
                        // 回溯，已经弹栈了，要减去弹出的值
                        sub_sum = (sub_sum-cur.val) / 10;
                        // cur 可以废弃了，置空，回溯上一层。
                        cur = null;

                    }else {
                        stack.push(cur);
                        // 不是叶子节点，还需要算右子树。
                        cur = cur.right;
                    }
                }

            }

        }
        return total_sum;

    }

}
