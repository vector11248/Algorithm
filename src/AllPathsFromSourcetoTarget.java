import java.util.*;

public class AllPathsFromSourcetoTarget {

    public static void main(String[] args) {
       int[][] graph = {{1,2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }
    public  static  List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph,res,path,0);
        return res;
        //System.out.println(res);
    }
    public static void dfs(int[][] graph, List<List<Integer>> res, List<Integer> path, int cur){
        int N=graph.length;
        //递归基，此时在恰好就在第N-1个节点,把最后一个节点加到每一条的Path，最为最后的节点。

        if(cur==N-1){
            path.add(cur);
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        //递归过程,对于一个普通的节点而言，对其所有的邻居节点进行深搜
        for(int neibor:graph[cur]){
            path.add(cur);
            dfs(graph, res, path, neibor);
            path.remove(path.size()-1);
        }


    }
}
