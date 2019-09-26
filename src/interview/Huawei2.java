package interview;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-25 19:11
 **/
public class Huawei2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N,M;
        N = sc.nextInt();
        M = sc.nextInt();
        int[] arr = new int[N];
        int[] sum = new int[N+1];
        sum[0] = 0;
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
            sum[i+1] = sum[i]+arr[i];
        }

        for(int i=0;i<M;i++){
            String caozuo = sc.next();
            int A = sc.nextInt();
            int B = sc.nextInt();
            if ("Q".equals(caozuo)){
                int subSum = sum[B]-sum[A-1];
                int avg = subSum/(B-A+1);
                System.out.println(avg);
            }else {
                arr[A-1] += B;
                for(int j = A;j<=N;j++){
                    sum[j] += B;
                }
            }

        }

    }

}
