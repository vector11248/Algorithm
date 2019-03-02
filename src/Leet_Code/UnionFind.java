package Leet_Code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-02-19 16:06
 **/
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
