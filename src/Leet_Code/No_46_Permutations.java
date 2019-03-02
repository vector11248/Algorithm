package Leet_Code;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-03-01 21:21
 **/
public class No_46_Permutations {

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<List<Integer>> res;

    public static void backtrack(int t,int[] nums){
        // t 代表回溯的第t层 ,从0开始数
        if (t>=nums.length){
            List<Integer> subAns = new ArrayList<>();
            for(int n:nums){
                subAns.add(n);
            }
            res.add(subAns);
            return;
        }else {
            for (int i=t;i<nums.length;i++){
                swap(nums,t,i);
                backtrack(t+1,nums);
                swap(nums,t,i);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length ==0 ) return null;
        res =  new ArrayList<>();
        backtrack(0,nums);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(permute(nums));
    }
}
