package Leet_Code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-10-30 16:32
 **/
public class Leetcode310_MinimumHeightTrees {

    class Node{
        int idx;
        List<Integer> neighbors;
        int degree = 0;
        Node(int idx){
            this.idx = idx;
            neighbors = new LinkedList<>();
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if( n == 0){
            List<Integer> res = new LinkedList<>();
            res.add(0);
            return res;
        }

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for(int[] edge : edges){
            nodes[edge[0]].neighbors.add(edge[1]);
            nodes[edge[1]].neighbors.add(edge[0]);
            ++nodes[edge[0]].degree;
            ++nodes[edge[1]].degree;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n ; i++) {

            // 叶子节点：degree 为 1,将所有叶子节点加入到队列中。
            if(nodes[i].degree == 1){
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){

            result = new ArrayList<>();
            int size = queue.size();
            while (size-->0){
                result.add(queue.peek());
                Node leave = nodes[queue.poll()];
                for(int neibor : leave.neighbors){
                    nodes[neibor].degree--;
                    leave.degree--;
                    if(nodes[neibor].degree == 1){
                        queue.add(neibor);
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {

    }


}
