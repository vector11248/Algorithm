package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-20 20:22
 **/
public class No_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findK(int[] arr,int start ,int end,int key){

        for(int i = start;i<= end;i++){
            if (arr[i] == key){
                return i;
            }
        }
        return -1;
    }


    public TreeNode buildHelper(int[] preorder,int[] inorder,int preL,int preR,int InL,int InR){

        if(preL>preR) return null;
        int root_val = preorder[preL];
        int root_index = findK(inorder,InL,InR,root_val);
        TreeNode root = new TreeNode(root_val);
        root.left = buildHelper(preorder,inorder,preL+1,preL + (root_index-InL),InL,root_index-1);
        root.right = buildHelper(preorder,inorder,preL + (root_index-InL) + 1,preR,root_index+1,InR);
        return root;

    }




    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // pre : 3 9 20 15 7
        // In :  9 3 15 20 7
        if(preorder.length != inorder.length){
            return null;
        }
        return buildHelper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

}
