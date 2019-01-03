package Algorithm_book;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-27 21:47
 **/
public class Graph {
    private final int V;// 图的顶点个数
    private int E;// 图的边数
    private Bag<Integer>[] adj; //邻接表
    public Graph(int V){ // 初始化含有V个顶点，互不联通的图。
        this.V = V;
        this.E = 0;
        this.adj = (Bag<Integer>[]) new Bag[V]; // 创建邻接表
        for (int v=0;v<V;v++){                  // 将所有链表初始化为空
            adj[v] = new Bag<Integer>();
        }
    }

}
