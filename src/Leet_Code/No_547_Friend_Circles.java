package Leet_Code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-02-25 10:51
 **/
public class No_547_Friend_Circles {

    public class UnionFind {
        HashMap<Integer,Integer> father;
        UnionFind(){
            father = new HashMap<>();
        }

        public void initialization(int[] nums){
            for (int i=0;i<nums.length;i++){
                father.put(nums[i],nums[i]);
            }
        }

        public void add(int key,int fa){
            if (father.containsKey(key)){
                return;
            }
            father.put(key,fa);
        }

        public int find(int key){
            int key_father = key;
            while (key_father != father.get(key_father)){
                key_father = father.get(key_father);
            }
            int temp = key;
            int temp_father;
            while (temp != key_father){
                temp_father = father.get(temp);
                father.replace(temp,key_father);
                temp = temp_father;
            }
            return key_father;
        }

        public void union(int x,int y){
            int fa_x = find(x);
            int fa_y = find(y);
            if (fa_x != fa_y){
                father.put(fa_x,fa_y);
            }
        }

        public int setNum(){
            // 输出集合个数
            Iterator iter = father.entrySet().iterator();
            while (iter.hasNext()){
                Object key = ((Map.Entry) iter.next()).getKey();
                find((Integer) key);
            }

            // 对所有val去重
            iter = father.entrySet().iterator();
            HashSet<Integer> counter = new HashSet<>();
            int num = 0;
            while (iter.hasNext()){
                Integer val = (Integer)( ((Map.Entry)iter.next()).getValue());
                if (counter.contains(val)){
                    continue;
                }else {
                    counter.add(val);
                    num+=1;
                }

            }
            return num;

        }

    }



    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length ==0 ) return 0;
        int n = M.length;
        int i,j;
        UnionFind unionFind = new UnionFind();
        for (i=0;i<n;i++){
            unionFind.add(i,i);
        }

        for (i=0;i<n;i++){
            for (j=i+1;j<n;j++){
                if (M[i][j]==1){
                    unionFind.union(i,j);
                }
            }
        }

        return unionFind.setNum();

    }

    public void dfs(int[][] M,int[] visited,int i){
        for (int j=0;j<M.length;j++){
            if (M[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(M,visited,j);
            }
        }
    }


    public int findCircleNum1(int[][] M) {
        if (M.length == 0 || M[0].length ==0 ) return 0;
        int n = M.length;
        int[] visited = new int[n];
        int cnt = 0;
        for (int i=0;i<n;i++){
            if (visited[i] == 0){
                dfs(M,visited,i);
                cnt++;
            }
        }
        return cnt;
    }

}
