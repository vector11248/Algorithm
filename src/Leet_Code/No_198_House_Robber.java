package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-23 09:16
 **/
public class No_198_House_Robber {

    public int rob(int[] nums) {

        int length = nums.length;
        if(length == 0) return 0;
        if(length == 1) return nums[0];
        if(length == 2) return Math.max(nums[1],nums[0]);
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2];
        for(int i=3;i<length;i++){
            dp[i] = Math.max(dp[i-2],dp[i-3])+nums[i];
        }
        return Math.max(dp[length-1],dp[length-2]);

    }

}
