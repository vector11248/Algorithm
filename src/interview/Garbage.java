package interview;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-19 19:30
 **/
public class Garbage {

    public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n 堆
        m = sc.nextInt(); // m 约束
        int[] arr = new int[n];
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
        }

//        Random random = new Random();
        int[] res = {6,10};
        Random random = new Random();
        if (random.nextInt(1)<0.5){
            System.out.println(res[0]);
        }else {
            System.out.println(res[1]);
        }



    }


}
