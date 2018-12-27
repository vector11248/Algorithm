package Leet_Code;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-26 13:35
 **/
public class No_204_Count_Primes {
    public static boolean isPrime(int num){
        for (int i=2;i<=Math.sqrt(num);i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }

    // 超时
    public static int countPrimes0(int n) {
        if(n<=2) return 0;
        int cnt = 1;
        for (int i=3;i<n;i++){
            if ((i%2!=0)&&isPrime(i)){
                cnt++;
            }
        }
        return cnt;
    }
    public static int countPrimes(int n) {
        // 筛法求质数
        int[] primeNum = new int[n+5];
        Arrays.fill(primeNum, 1);
        primeNum[0] = 0;
        primeNum[1] = 0;
        for (int i=2;i<=Math.sqrt(n);i++){
            if (primeNum[i]==0) continue;
            for (int j = i*i;j<=n;j+=i){
                primeNum[j]=0;
            }
        }
        int cnt = 0;
        for (int i=0;i<n;i++){
            if (primeNum[i]==1){
                cnt++;
            }

        }
        return cnt;
    }
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
