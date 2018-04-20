import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @program: Leetcode
 * @description: leetcode818
 * @author: Wangky
 * @create: 2018-04-19 23:40
 **/
public class RaceCar
{
    private  static  boolean[][] visited = new boolean[6][6];
    private static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
   private static int[][] maze = new int[5][5];
    private static Node[][] pre = new Node[6][6];
    public static void main(String[] args) {
        int n;
        n = 5;
        Scanner sc = new Scanner(System.in);
//        int[][] maze={};
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                maze[i][j] = sc.nextInt();
                visited[i][j]= false;
            }
        }
        Node start = new Node(0,0);
        Node end = new Node(n,n);
        bfs(start,end,visited,dir,maze,n);
        for (int i = n-1; i >0 ; i--) {
            System.out.println(pre[i][i].x);
        }

    }
    private static class Node{
        int x;int y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    //参数N代表迷宫范围,一个5*5的迷宫，[0,4]，N取4。
    private static boolean isValid(Node n,int N ,int[][] maze){
        if (n.x<0 || n.y>N || n.x>N ||n.y <0 || maze[n.x][n.y]==1 ) return false;
        return true;
    }

    private static void bfs(Node start,Node end,boolean[][] visited,int[][] dir,int[][] maze,int n){
        Queue<Node> Q = new LinkedList<Node>();

        Node V; //从队列当中取的临时节点
        Node Vneighb; //临时节点的邻居节点

        //将起始点Node放入队列
        ((LinkedList<Node>) Q).push(start);
        //标记访问
        visited[start.x][start.y] = true;

        while (!Q.isEmpty()){

//            V = Q.peek();
            V = Q.element();
            ((LinkedList<Node>) Q).pop();
            Vneighb = new Node(V.x + dir[0][0], V.y + dir[0][1]);
            if (Vneighb == end) {
                //记录路径
                return;//
            }

            if (isValid(Vneighb, n, maze) && !visited[Vneighb.x][Vneighb.y]) {
                ((LinkedList<Node>) Q).push(Vneighb);
                visited[Vneighb.x][Vneighb.y] = true;
                pre[Vneighb.x][Vneighb.y] = V;
            }

            Vneighb = new Node(V.x + dir[1][0], V.y + dir[1][1]);
            if (Vneighb == end) {
                //记录路径
                return;//
            }

            if (isValid(Vneighb, n, maze) && !visited[Vneighb.x][Vneighb.y]) {
                ((LinkedList<Node>) Q).push(Vneighb);
                visited[Vneighb.x][Vneighb.y] = true;
                pre[Vneighb.x][Vneighb.y] = V;
            }

            Vneighb = new Node(V.x + dir[2][0], V.y + dir[2][1]);
            if (Vneighb == end) {
                //记录路径
                return;//
            }

            if (isValid(Vneighb, n, maze) && !visited[Vneighb.x][Vneighb.y]) {
                ((LinkedList<Node>) Q).push(Vneighb);
                visited[Vneighb.x][Vneighb.y] = true;
                pre[Vneighb.x][Vneighb.y] = V;
            }

            Vneighb = new Node(V.x + dir[3][0], V.y + dir[3][1]);
            if (Vneighb == end) {
                //记录路径
                return;//
            }

            if (isValid(Vneighb, n, maze) && !visited[Vneighb.x][Vneighb.y]) {
                ((LinkedList<Node>) Q).push(Vneighb);
                visited[Vneighb.x][Vneighb.y] = true;
                pre[Vneighb.x][Vneighb.y] = V;
            }

        }
        return ;
    }
}
