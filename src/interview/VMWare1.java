package interview;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-18 19:26
 **/
public class VMWare1 {

    public static void main(String[] args) {
        int T ;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        int t=1;
        int res = -1;
        while (t<=T){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int cnt = 0;
            if (n==1){
                System.out.println(k-1);
            }else {
                int start =(int)Math.pow(10,n-1);
                while (cnt<k){
                    if (isParaline(start)){
                        cnt++;
//                        start++;
                    }
                    start++;
                }
                res = start-1;
                System.out.println(res);
            }
            t++;

        }

//        return;
    }


    public static boolean isParaline(int n){
        String s = String.valueOf(n);
        int i=0,j=s.length()-1;
        boolean flag = true;
        while (i<j){
            if (s.charAt(i) != s.charAt(j)){
                flag = false;
                break;
            }else {
                i++;
                j--;
            }
        }
        return flag;
    }

}
