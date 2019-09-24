package interview;
import java.util.Scanner;

public class bd004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int t = 0;
        while (t< T) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            int[] dp = new int[m+1];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for(int j = 0; j < n; j++) {
                int temp = arr[j];
                int cur = j;
                for(int i = m; i >= temp; i--) {
                    dp[i] = Math.max(dp[i], dp[i - temp] + 1);
                    cur = Math.min(cur, j - dp[i - temp]);
                }
                System.out.print(cur + " ");
            }
            System.out.println();
            t++;
        }
    }
}