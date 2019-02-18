package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-23 10:01
 **/
public class No_279_Perfect_Squares {

    public static int numSquares(int n) {

        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i=1;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for (int j=1;j*j <= i;j++){
                if (dp[i-j*j] < min){
                    min = dp[i - j*j];
                }
                dp[i] = min + 1;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        for(int i=0;i<n;i++){
            System.out.println("dp["+i+"],  "+numSquares(i));
        }
    }

}
