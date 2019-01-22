package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-14 21:34
 **/
public class No_53_Maximum_Subarray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0;i<nums.length;i++){
           if (curSum <= 0){ // 最终的结果不需要考虑curSum
               curSum = nums[i];
           }else {
               curSum += nums[i];
           }
           if (curSum > maxSum){
               maxSum = curSum;
           }
        }
        return maxSum;
    }


}
