package Leet_Code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-02-26 09:19
 **/
public class No_684_Redundant_Connection {


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


    public int[] findRedundantConnection(int[][] edges) {

        int result_i = -1; // result index
        int i=0;
        UnionFind uf = new UnionFind();
        boolean flag; // 此flag可以认为是有没有重复的可能。
        for (int[] edge:edges){
            flag = false;
            for (int j=0;j<2;j++){
                if (!uf.father.containsKey(edge[j])){
                    flag = true; // true 代表将不会产生重复边
                    uf.add(edge[j],edge[j]);
                }
            }

            if(!flag && uf.find(edge[0]) == uf.find(edge[1])){
                result_i = i;
            }
            uf.union(edge[0],edge[1]);
            i++;
        }
        if (result_i == -1){
            return new int[2];
        }
        return edges[result_i];

    }

}

