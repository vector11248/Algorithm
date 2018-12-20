package Leet_Code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-16 10:34
 **/
public class leetcode_958CheckCompletenessofaBinaryTree {

    //  Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public  static boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) queue).push(root);

        TreeNode cur;

        while ( ( cur = ((LinkedList<TreeNode>) queue).poll()) != null){
            ((LinkedList<TreeNode>) queue).add(cur.left);
            ((LinkedList<TreeNode>) queue).add(cur.right);
        }


        while (!queue.isEmpty()){
            cur = ((LinkedList<TreeNode>) queue).poll();
            if(cur!=null){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
            TreeNode n1 = new TreeNode(1);
            TreeNode n2 = new TreeNode(2);
            TreeNode n3 = new TreeNode(3);
            TreeNode n4 = new TreeNode(4);
            TreeNode n5 = new TreeNode(5);
            TreeNode n6 = new TreeNode(6);
            n1.left = n2;
            n1.right = n3;
            n2.left = n4;
            n2.right = n5;
            n3.left = n6;
        System.out.println( isCompleteTree(n1));
    }



}
