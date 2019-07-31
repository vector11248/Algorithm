package Leet_Code;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-03-05 17:57
 **/
public class No_60_Permutation_Sequence {
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static List<String> res = new ArrayList<String>();
    public static void backtrack(int t,int n,char[] ans,int[] nums){
        // t 代表递归深度，root 代表根节点的值
        // t starts from 0
        // n 代表递归的总深度。不计入起始的第一层
        if (t>=n-1){
            String temp_ans = new String(ans);
            res.add(temp_ans);
            return;
        }
        for (int i=t;i<n-1;i++){
            swap(nums,i,t);
            ans[t+1] =(char) (nums[t]+'0');
            backtrack(t+1,n,ans,nums);
            swap(nums,i,t);

        }

    }
    public static String getPermutation(int n, int k) {
        int product = 1;
        for(int i=1;i<n;i++){
            // 先计算 (n-1)!
            product *= i;
        }
        int start_num = k/product + 1; // 根 几
        int in_order = k%product;     // 根是start_num里面的第in_order个
        char[] ans = new char[n];
        ans[0] = (char)(start_num + '0');

        int[] nums = new int[n-1];
        for(int i=0;i<start_num-1;i++){
            nums[i] = i+1;
        }
        for(int i=start_num-1;i<n-1;i++){
            nums[i] = i+2;
        }
        backtrack(0,n,ans,nums);
        System.out.println(res);
        return res.get(in_order-1);

    }

    public static void main(String[] args) {
        System.out.println(getPermutation(2,1));
    }
}
