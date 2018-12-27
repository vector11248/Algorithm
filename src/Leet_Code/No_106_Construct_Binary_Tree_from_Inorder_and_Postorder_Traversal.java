package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-21 19:40
 **/
public class No_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int findK(int[] arr,int start ,int end,int key){

        for(int i = start;i<= end;i++){
            if (arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static TreeNode buildMyTree(int[] inorder, int[] postorder, int InL,int InR,int PostL,int PostR){

        if (InL > InR) return null;
        if (PostL > PostR) return null;

        int root_val = postorder[PostR];
        int root_index = findK(inorder,InL,InR,root_val);
        TreeNode root = new TreeNode(root_val);
        root.left = buildMyTree(inorder,postorder,InL,root_index-1,PostL,PostL+(root_index-InL)-1);
        root.right = buildMyTree(inorder,postorder,root_index+1,InR,PostR-(InR-root_index),PostR-1);
        return root;


    }



    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length){
            return null;
        }
        return buildMyTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);


    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode n = buildTree(inorder,postorder);
        System.out.println(n.val);
    }






}
