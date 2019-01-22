package Leet_Code;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-18 20:54
 **/
public class No_673_Number_of_Longest_Increasing_Subsequence {
    public static int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        if(length ==0 ) return 0;
        int[] dp = new int[length];
        int[] cnt = new int[length];
        for (int i=0;i<length;i++){
            dp[i] = 1;
            cnt[i] = 1;
        }
        int maxlength = 0; // 要从0开始，
        int ans = 0;
        for (int i = 1;i<length;i++){
            for (int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    if (dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                        cnt[i] = cnt[j];
                    }else if (dp[i] == dp[j]+1){
                        cnt[i] += cnt[j];
                    }
                }

            }
            if (dp[i] > maxlength) {
                // 此处的if才可以 完全大于号
                maxlength = dp[i];
                ans = cnt[i];
            }else if(dp[i] == maxlength){
                ans += cnt[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] numbs = {1,2,4,3,5,4,7,2};
        System.out.println(findNumberOfLIS(numbs));
    }
}









