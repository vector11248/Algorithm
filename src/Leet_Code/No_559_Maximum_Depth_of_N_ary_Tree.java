package Leet_Code;

import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-02 15:50
 **/
public class No_559_Maximum_Depth_of_N_ary_Tree {

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
    private int ans = 0;
    public int maxDepth(Node root) {
        if (root == null) return 0;
        maxDepth(root,1);
        return ans;

    }
    public void maxDepth(Node root , int depth){
        if (root == null) return;
        ans = Math.max(ans,depth);
        for (Node node : root.children){
            maxDepth(node,depth+1);
        }
    }
}
