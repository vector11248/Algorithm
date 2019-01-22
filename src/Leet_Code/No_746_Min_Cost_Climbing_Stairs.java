package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-21 18:54
 **/
public class No_746_Min_Cost_Climbing_Stairs {

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i=2;i<=length;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1] , dp[i-2]+cost[i-2]);
        }
        return dp[length];

    }

}
