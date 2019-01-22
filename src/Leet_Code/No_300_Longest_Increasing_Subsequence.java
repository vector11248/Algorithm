package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-18 20:33
 **/
public class No_300_Longest_Increasing_Subsequence {

    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if(length ==0 ) return 0;
        int[] dp = new int[length];
        for (int i=0;i<length;i++){
            dp[i] = 1;
        }
        int max = 1;

        for (int i=0;i<length;i++){
            for (int j=0;j<i;j++){
                if ( nums[j] < nums[i]){
                    dp[i] = (dp[i] > dp[j]+1) ? dp[i]:(dp[j]+1);
                }
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums1 = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums1));
    }

}
