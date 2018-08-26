package hihocoder;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-08-26 09:40
 **/
public class CircleDetect {

    protected static class Edge{
        int to; // 该边指向的节点
        int next;//在同一个链表下，该边临接的下一条边。
        // eg:3-->1--->4-->-1;即node 3 的临接点有 node 1, node 4。
        // 此处用了一个tric,用数组模拟链表，每次插入，是在链表的头部插入。
    }


    protected static int maxn = (int) 1e5+10;

    protected static int cnt;
//            = 0;//边的条数


    protected static Edge[] edges;
//            = new Edge[maxn];

    protected static int[] heads;
//            = new int[maxn]; // heads[u] 代表节点u邻接链表的头节点。heads初值 -1

    protected static int[] vis ;
//            = new int[maxn]; // vis 初值为0，代表均未被访问过

    protected static int ans;
//            = 0;

    protected static void dfs(int d){
        vis[d] = 1;
        for(int i=heads[d];i!=-1;i=edges[i].next){
            // 对d 的所有的邻接点进行 dfs.i-->边的cnt
            int v = edges[i].to;
            if(vis[v]==0) dfs(v);
            if(vis[v]==1) {
//                System.out.println("YES");
                ans = 1;
                return;
            }
        }
        vis[d] = 2;//在d的所有邻接点遍历完后，若无发现环，则回溯后，把d设置为vis[d]=2;
    }

    public static void add_edge(int begin,int end){
        cnt++;
        edges[cnt] = new Edge();
        edges[cnt].to = end;
        edges[cnt].next = heads[begin];
        heads[begin] = cnt;
    }


    public static void main(String[] args) {

        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t--!=0){

            //每组测试用例都需要进行初始化
             cnt = 0;//边的条数
             edges = new Edge[maxn];
             heads = new int[maxn]; // heads[u] 代表节点u邻接链表的头节点。heads初值 -1
             vis = new int[maxn]; // vis 初值为0，代表均未被访问过
             ans = 0;

            int n,m;
            n = sc.nextInt();
            m = sc.nextInt();

            for (int i=1;i<=n;i++){
                heads[i] = -1;
            }

            for(int i=1;i<=m;i++){
                int u,v;
                u = sc.nextInt();
                v = sc.nextInt();
                add_edge(u,v);
            }

            for(int i=1;i<=n;i++){ // n个节点
                if(vis[i]==0){
                    dfs(i);
                }
            }
            if(ans==1){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }
        return;

    }
}
