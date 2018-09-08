package interview;

import java.util.Scanner;

/**

 **/
public class No1 {

    public static long ans(long n,long m){
        if(n==1&&m==1){
            return 1;
        }else if(n==1){
            return m-2;
        }else if(m==1){
            return n-2;
        }else {
            return (n-2)*(m-2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while ((t--)!=0){
            long n,m;
            n = sc.nextLong();
            m = sc.nextLong();
            long res = ans(n,m);
            System.out.println(res);
        }
    }

}
