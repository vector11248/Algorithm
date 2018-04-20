import javax.xml.soap.Node;
import java.util.*;

/**
 * @program: Leetcode
 * @description: BFS_POJ3984
 * @author: Wangky
 * @create: 2018-04-20 14:23
 **/
public class Maze {
    private static class Node{
        int x,y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        int[][] maze = new int[5][5];
        boolean[][] visited = new boolean[5][5];
        int[][] dir = {{1,0},{-1,0},{0,1},{1,-1}};
        Node[][] nodes = new Node[5][5];
        Node[][] pre = new Node[5][5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <5 ; j++) {
                maze[i][j] = sc.nextInt();
                visited[i][j] = false;
                nodes[i][j] = new Node(i,j);
            }
        }
        bfs(nodes[0][0],nodes[4][4],maze,dir,visited,pre,nodes);
        int  temp1 = 4;
        int  temp2 = 4;
//        List<Node> list = new ArrayList();
        Stack<Node> list = new Stack<Node>();
        list.add(nodes[4][4]);
        while (pre[temp1][temp2].x != 0 || pre[temp1][temp2].y!=0){
            list.add(pre[temp1][temp2]);
            int x1 = temp1;
             temp1 = pre[temp1][temp2].x;
             temp2 = pre[x1][temp2].y;
        }
        list.add(nodes[0][0]);

        while (!list.isEmpty()){
            System.out.println("("+list.peek().x+", "+list.peek().y+")");
            list.pop();
        }



//        System.out.println(pre[4][4].y);
    }

    private static boolean isValid(Node node,int[][] maze){
        if(maze[node.x][node.y]==1 || node.x<0 ||node.y<0||node.x>=5||node.y>=5) return false;
        return true;
    }

    private static void bfs(Node start,Node end,int[][] maze ,int[][] dir,boolean[][] visited,Node[][] pre,Node[][] nodes){
        Queue<Node> queue = new LinkedList<Node>();
        ((LinkedList<Node>) queue).push(start);
        visited[start.x][start.y] = true;
        while (!queue.isEmpty()){
            Node V = queue.element();
            ((LinkedList<Node>) queue).pop();
            for (int i = 0; i < 4; i++) {
                //Node neighb = new Node(V.x+dir[i][0],V.y+dir[i][1]);
                if(V.x+dir[i][0]<0 || V.y+dir[i][1]<0 || V.x+dir[i][0]>4 || V.y+dir[i][1]>4) continue;
                Node neighb = nodes[V.x+dir[i][0]][V.y+dir[i][1]];
                if(neighb.x == end.x && neighb.y == end.y){
                    //ok 到终点了
                    visited[neighb.x][neighb.y] = true;
                    pre[neighb.x][neighb.y] = V;
                    return;
                }

                if(!visited[neighb.x][neighb.y] && isValid(neighb,maze)){
                    ((LinkedList<Node>) queue).push(neighb);
                    visited[neighb.x][neighb.y] = true;
                    pre[neighb.x][neighb.y] = V;
                }
            }
        }
        return;

    }

}
