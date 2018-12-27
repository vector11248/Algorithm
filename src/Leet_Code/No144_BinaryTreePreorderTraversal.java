package Leet_Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-20 18:17
 **/

public class No144_BinaryTreePreorderTraversal {


  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<Integer> preorderTraversal(TreeNode root) {
        // 要实现前序非递归遍历
        // 核心思路：
        // 一路向左，将访问到的节点直接加入结果集。同时入栈。
        // 当到达最左下角的时候，此时左边都访问完了，此时可以弹栈，去访问右边。如此。。
        // DFS的非递归实现本质上是在协调入栈、出栈和访问，三种操作的顺序。
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty() ){
            while ( cur != null ){
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            if ( !stack.isEmpty()){
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return result;
    }

}
