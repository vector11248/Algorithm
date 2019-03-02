package Leet_Code;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-02-26 14:31
 **/
public class No_128_Longest_Consecutive_Sequence {

    public class UnionFind{
        HashMap<Integer,Integer> father;
        HashMap<Integer,Integer> size; // 每一个集合的size
        int component;// 集合的个数
        UnionFind(){
            father = new HashMap<>();
            size = new HashMap<>();
            component = 0;
        }

        public void initialitation(int[] nums){
            for (int i=0;i<nums.length;i++){
                father.put(nums[i],nums[i]);
                size.put(nums[i],1);
            }
        }

        public void add(int key){
            if (father.containsKey(key)) return;
            father.put(key,key);
            size.put(key,1);
            component += 1;
        }

        public int find(int key){
            int key_father = key;
            while (key_father != father.get(key_father)){
                key_father = father.get(key_father);
            }
            int temp_father;
            int temp = key;
            while (temp != key_father){
                temp_father = father.get(temp);
                father.replace(temp,key_father);
                size.replace(key_father,size.get(key_father) + size.get(temp));
                size.replace(temp,0);
                temp = temp_father;
            }
            return key_father;
        }

        public void union(int x,int y){
            int fa_x = find(x);
            int fa_y = find(y);
            if (fa_x != fa_y){
                father.put(fa_x,fa_y);
                size.replace(fa_x,0);
                size.replace(fa_y,size.get(fa_x) + size.get(fa_y));
                component -= 1;
            }
        }



    }

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;
        UnionFind uf = new UnionFind();
        int ans = 0;
        for (int num :nums){
            uf.add(num);
            if (uf.father.containsKey(num-1)){
                uf.union(num,num-1);
            }
            if (uf.father.containsKey(num+1)){
                uf.union(num,num+1);
            }
        }
        for (int num:nums){
            if (ans < uf.size.get(num)){
                ans = uf.size.get(num);
            }
        }

        return ans;
    }

    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 1;
        int l = 1;
        for(int i=1;i<nums.length;i++){
            if ((nums[i] - nums[i-1])==1){
                l ++;
            }else if (nums[i] == nums[i-1]){
                continue;
            }else {
                longest = Math.max(l,longest);
                l = 1;
            }
        }
        longest = Math.max(l,longest);
        return longest;
    }

}
