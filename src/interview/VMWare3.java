package interview;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-18 19:44
 **/
public class VMWare3 {

    public static void main(String[] args) {
        int a,b,k;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        k = sc.nextInt();
        int cnt = 0;
        for(int i=a;i<=b;i++){
            if (i%k == 0){
                boolean flag = false;
                for(int j=2;j<=k-1;j++){
                    if (i%j == 0){
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }

}
