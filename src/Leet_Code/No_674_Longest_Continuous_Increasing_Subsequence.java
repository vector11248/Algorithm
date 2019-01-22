package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-19 13:23
 **/
public class No_674_Longest_Continuous_Increasing_Subsequence {
    public int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int[] dp = new int[length];
        dp[0] = 1;
        int max = dp[0];
        for (int i=1;i<length;i++){
            if (nums[i]>nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }else {
                dp[i] = 1;
            }
            if (dp[i]>max){
                max = dp[i];
            }
        }

        return max;
    }
}
