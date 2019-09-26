package interview;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-25 19:04
 **/
public class Minganci01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String mingan = sc.next();
        int n = mingan.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append("*");
        }
        System.out.println(str.replaceAll(mingan,sb.toString()));

    }

}
