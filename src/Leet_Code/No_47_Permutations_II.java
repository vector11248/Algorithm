package Leet_Code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-03-02 11:26
 **/
public class No_47_Permutations_II {

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static Set res;

    public static void backtrack(int t,int[] nums){
        if(t==nums.length){
            List<Integer> subAns = new ArrayList<Integer>();
            for(int n:nums){
                subAns.add(n);
            }
            res.add(subAns);
        }else{
            for(int i = t;i<nums.length;i++){
                swap(nums,t,i);
                backtrack(t+1,nums);
                swap(nums,t,i);
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        res = new HashSet<>();
        backtrack(0,nums);
        List<List<Integer>> final_res = new ArrayList<>(res);
        return final_res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }

}
