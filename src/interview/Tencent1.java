package interview;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-01 19:59
 **/
public class Tencent1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        for (int i=0;i<n;i++){
            w[i] = sc.nextInt();
        }
        int maxMulti = 0;
        for (int i=0;i<n;i++){
            for (int j = i;j<n;j++){
                if (i == j){
                    if (w[i]*w[i] > maxMulti){
                        maxMulti = w[i]*w[i];
                    }
                }else {
                    int min = Integer.MAX_VALUE;
                    int tempSum = 0;
                    for( int k = i;k<=j;k++){
                        if (w[k] < min){
                            min = w[k];
                        }
                        tempSum += w[k];
                    }
                    if (tempSum * min > maxMulti){
                        maxMulti = tempSum * min;
                    }
                }
            }
        }
        System.out.println(maxMulti);
        return;
        //return maxMulti;
    }
}
