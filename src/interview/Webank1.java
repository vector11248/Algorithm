package interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-19 17:13
 **/
public class Webank1 {



    public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // view
        m = sc.nextInt(); // path

         ArrayList<Integer> adj[] = new ArrayList[101];
         boolean[] visited = new boolean[101]; // 从1计数
         int[] preNode = new int[101];

        // construct

        for (int i=0;i<adj.length;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        int s = sc.nextInt();
        int t = sc.nextInt();
//        int[] path = new int[m+1];
        boolean[] nodes = new boolean[n+1];


        dfs(s,t,adj,visited,preNode);
        if (visited[t]){
            for(int x=t;x!=s;x = preNode[x]){
                nodes[x] = true;
            }
        }
        for(int i=1;i<=n;i++){
            if (!nodes[i] && i != s){
                System.out.print(i+" ");
            }
        }

    }

    public static void dfs(int s,int t,ArrayList<Integer> adj[],boolean[] visited,int[] preNode){
        visited[s] = true;
        for(int nei:adj[s]){
            if (!visited[nei]){
                preNode[nei] = s;
                dfs(nei,t,adj,visited,preNode);
            }
            if (nei == t){
                break;
            }

        }
    }

}
