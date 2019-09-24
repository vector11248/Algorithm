package interview;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-22 08:39
 **/
public class ByteDance02 {
    public static void main(String[] args) {
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        int t=0;
        while (t<T){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int[][] dp =new int[n+1][m+1];
            for(int i=0;i<dp[0].length;i++){
                dp[0][i] = 0;
            }
            for(int i=1;i<=n;i++){
                for(int j=0;j<m+1;j++){
                    if (arr[i-1]<j){
                        dp[i][j] = i+1;
                    }else {
                        dp[i][j] = dp[i-1][j-arr[i-1]];
                    }
                }
            }
            for(int i=0;i<n;i++){
                System.out.println(dp[i][m]);
            }
            t++;
        }
    }
}
