package KickStart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-15 15:05
 **/
public class KSE03_18RoundC_Planet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int time = 1;
        while ((time )<= T){
            int n = sc.nextInt(); //  n 个顶点
            // construct a graph
            // 邻接表
            ArrayList<Integer> adj[] = new ArrayList[n+1];
            for (int i=0;i<adj.length;i++){
                adj[i] = new ArrayList<>();
            }
            for(int i=0;i<n;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                adj[x].add(y);
                adj[y].add(x);
            }

            // compute the degree of each node
            int[] degree = new int[n+1];
            Queue<Integer> q = new LinkedList<>();
            for(int i=1;i<=n;i++){
                degree[i] = adj[i].size();
                if (degree[i] == 1){

                    // 度为1的点(即只有一条边)，入队列
                    ((LinkedList<Integer>) q).push(i);
                }
            }

            int[] dis = new int[n+1];
            // Topological sort
            while (!q.isEmpty()){
                int node = q.peek();
                q.poll();

                dis[node] = -1; // 代表该node节点不在环里，可以剔除掉，用 -1 做一个标记

                // 节点node 的所有邻接点的度减1
                for(int i=0;i<adj[node].size();i++){
                    int v = adj[node].get(i);
                    degree[v]--;
                    if (degree[v] == 1){
                        q.offer(v);
                    }
                }
            }

            // Add node in the cycle
            // 复用该 queue
            //  从环里往外bfs
            for(int i=1;i<=n;i++){
                if (dis[i] == 0){
                    q.offer(i);
                }
            }

            while (!q.isEmpty()){
                int node = q.peek();
                q.poll();
                for(int i=0;i<adj[node].size();i++){
                    int v=adj[node].get(i);
                    if (dis[v] == -1){
                        // 如果该节点在环外
                        dis[v] = dis[node]+1;
                        q.offer(v);
                    }
                }
            }

            System.out.print("Case #"+time+": ");
            for(int i=1;i<=n;i++){
                System.out.print(dis[i] + " ");
            }
            System.out.println();
            time++;

        }
    }


}
