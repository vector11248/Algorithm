package codeM;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-05-28 19:23
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[11];
        int n = sc.nextInt();
        int m = sc.nextInt();
        double sum1 = 0;//计算特价优惠
        double sum2 = 0;//不计算特价优惠

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            sum2+=a[i];
            int special = sc.nextInt();
            if(special == 1){
                sum1+=a[i]*0.8;
            }else{
                sum1+=a[i];
            }
        }
        double ans = sum2;

        for(int i=0;i<m;i++){
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(sum2 >= b ){
                double temp = sum2-c;
                if(temp<ans){
                    ans = temp;
                }
            }
        }

        System.out.println(String.format("%.2f",Math.min(ans,sum1)));
    }
}
