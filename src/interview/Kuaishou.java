package interview;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-16 21:00
 **/
public class Kuaishou {
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(abss(arr));

    }

    public static int abss(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }

        int temp[][]=new int[arr.length+1][sum/2+1];
        for(int i=0;i<arr.length;i++)
            for(int capacity=1;capacity<=sum/2;capacity++)
            {
                temp[i+1][capacity]=temp[i][capacity];
                if(arr[i]<=capacity && temp[i][capacity-arr[i]] +arr[i]>temp[i][capacity]){
                    temp[i+1][capacity]=temp[i][capacity-arr[i]]+arr[i];//可以放，且值比之前要大，则更新
                }
            }
        int max1 =  Math.max(temp[arr.length][sum/2], sum-temp[arr.length][sum/2]);
        int max2 = sum - max1;
        return Math.abs(max1-max2);
    }

}
