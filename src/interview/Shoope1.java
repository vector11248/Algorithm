package interview;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-14 19:40
 **/
public class Shoope1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String m = chan216(n);
        System.out.println(m);
        System.out.println( isParalined(m) );
    }
    public static String chan216(int n){

        String hex  = "";
        while (n != 0){
            int hexValue = n % 16;
            char hexDigit = (hexValue <= 9 && hexValue >=0) ? (char) (hexValue+'0'):(char)(hexValue-10+'A');
            hex = hexDigit+hex;
            n = n/16;
        }
        return hex;

    }

    public static int isParalined(String m){
        int i = 0; int j = m.length()-1;
        while (i<j){
            if (m.charAt(i) == m.charAt(j)){
                i++;
                j--;
            }else {
                break;
            }
        }
        if (i<j){
            return 0;
        }else {
            return 1;
        }


    }
}
