package interview;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-01 21:45
 **/
public class Tencent2 {

    public static void main(String[] args) {
        int t,k;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        k = sc.nextInt();
        int[] tox = new int[100001];
        tox[0] = 1;
        long[] fax = new long[100001];
        fax[0] = 0;
        for(int i = 1;i<=100000;i++){
            if (i<k){
                tox[i] = 1;
                continue;
            }
            if ( i==k ){
                tox[i] = 2;
                continue;
            }
            tox[i] = tox[i-k] + tox[i-1];

        }
        for(int i=1;i<=100000;i++){
            fax[i] = fax[i-1] + tox[i];
        }
        int a,b;
        while (t>0){
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(fax[b]-fax[a-1]);
            t--;
        }
       // return 0;

     }
}
