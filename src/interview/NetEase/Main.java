package interview.NetEase;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-08-03 16:54
 **/
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
        return;
    }
}
