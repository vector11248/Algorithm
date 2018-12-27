package Leet_Code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-20 18:33
 **/
public class No_145_BinaryTreePostorderTraversal {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        // 总体思路及 代码与前序非递归遍历差不多。两个区别：
        // （1）将所有节点均视为"根"节点。
        // （2）对于根节点，要先判断其右子树，是否被访问过。如果右访问过，则将该节点加入结果集。
        // 如果没有访问过右，则先去访问右。所以在此处需要设置一个标志位用于确定右边是否被访问过。
        // 参考链接：https://blog.csdn.net/Hk_john/article/details/70010535

        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        //该hash set 用于判断该节点是否是第一次被访问。
        HashSet<TreeNode> visited = new HashSet<>();

        TreeNode cur = root;
        while (cur != null ||! stack.isEmpty() ){

            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty()){
                cur = stack.pop();

                // 通过hashset 判断取出来的该节点是否被访问过。未访问的则加入该set
                if (visited.contains(cur)){
                    // 已经访问过该节点一次了，此时即此节点右边访问完。此时可以将该节点加入结果集。
                    result.add(cur.val);
                    cur = null;
                }else {
                    // 若第一次访问，则将该节点再次入栈。置换标志位。访问右边节点。
                    stack.push(cur);
                    visited.add(cur);
                    cur = cur.right; // 该右节点再作为一棵树加入进去访问。
                }

            }

        }
        return  result;
    }





}
