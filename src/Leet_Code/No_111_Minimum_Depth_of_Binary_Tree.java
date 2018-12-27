package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-21 20:34
 **/
public class No_111_Minimum_Depth_of_Binary_Tree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        return 1+Math.min(minDepth(root.left),minDepth(root.right));


    }

    public static void main(String[] args) {

    }



}
