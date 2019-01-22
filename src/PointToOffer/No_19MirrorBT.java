package PointToOffer;


/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-09 20:14
 **/
public class No_19MirrorBT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public  static void mirrorOfBinaryTree(TreeNode root){
        if (root == null || (root.left == null && root.right == null)) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null){
            mirrorOfBinaryTree(root.left);
        }
        if (root.right != null){
            mirrorOfBinaryTree(root.right);
        }


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        mirrorOfBinaryTree(root);
        System.out.println(root.val);  // 7
        System.out.println(root.left.val); // 8
        System.out.println(root.right.val); // 3
        System.out.println(root.left.right.val); // 5
        System.out.println(root.left.left.val);// 7
        System.out.println(root.right.right.val); // 4
    }



}
