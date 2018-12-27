package Leet_Code;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-25 15:11
 **/
public class No_95_Unique_Binary_Search_Trees_II {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> helper(int start,int end){
        List<TreeNode> result = new LinkedList<TreeNode>();
        //  1....k....n
        //  1....k-1 k k+1...n
        //  k as the root

        if (start > end){
            result.add(null);
            return result;
        }
        for (int k = start;k<=end;k++){
            List<TreeNode> left_tree = helper(start,k-1);
            List<TreeNode> right_tree = helper(k+1,end);

            for (TreeNode l :left_tree){
                for (TreeNode r:right_tree){
                    TreeNode current_root = new TreeNode(k);
                    current_root.left = l;
                    current_root.right = r;
                    result.add(current_root);
                }
            }

        }
        return result;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return helper(1,n);
    }
}
