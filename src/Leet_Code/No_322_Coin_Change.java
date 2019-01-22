package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-16 19:49
 **/
public class No_322_Coin_Change {


    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        dp[0] = 0;
        int temp_max = amount+1;// 不会有比它更大大了。
        for (int i = 1;i<=amount;i++){
            dp[i] = temp_max;
        }
        for (int i = 1;i<=amount;i++){
            for (int j = 0;j<coins.length;j++){
                if (i-coins[j]< 0){
                    continue;
                }
                dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

}
