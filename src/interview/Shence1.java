package interview;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-08-28 22:59
 **/
public class Shence1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> q1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> q2 = new PriorityQueue<Integer>();

        int n;
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
            q1.add(a[i]);
        }
        int m;
        m = sc.nextInt();
        int[] b = new int[m];
        for (int i=0;i<m;i++){
            b[i] = sc.nextInt();
            q2.add(b[i]);
        }
        int res = 0;
        while (!q1.isEmpty() && !q2.isEmpty()){
            int temp1 = q1.poll();
            int temp2 = q2.poll();
            if (temp1<=temp2){
                res++;
            }
        }

        System.out.println(res);


    }
}
