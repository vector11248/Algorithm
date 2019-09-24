package KickStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-13 12:20
 **/
/*
public class KSE07_18RoundF_CommonAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int i=1;
        while (i<=T){
            int L = sc.nextInt();
            String A = sc.next();
            String B = sc.next();
            int cnt = 0;
            for (int j=0;j<L;j++){
                for(int k=j;k<L;k++){
                    boolean flag = false;
                    char[] charsOfA = A.substring(j,k+1).toCharArray();
                    Arrays.sort(charsOfA);
                    for (int p = 0;p<L;p++){
                        if (flag){
                            break;
                        }
                        for(int q=p;q<L;q++){
                            if (flag){
                                break;
                            }
                            char[] charsOfB = B.substring(p,q+1).toCharArray();
                            Arrays.sort(charsOfB);
                            if (charsOfA.length != charsOfB.length){
                                continue;
                            }
                            int ii;
                            for(ii =0 ;ii<charsOfA.length;ii++){
                                if (charsOfA[ii] != charsOfB[ii]){
                                    break;
                                }
                            }
                            if (ii==charsOfA.length){
                                cnt++;
                                flag = true;
                            }
                        }
                    }
                }
            }
            System.out.print("Case #"+i+": ");
            System.out.print(cnt + " ");
            System.out.println();
            i++;
        }
    }
}
*/
// 预处理 B 字符串，把B 的所有的sorted子串都加到一个set里面去
    // 然后对于A的所有的排序子串 每次从 set 里取，看能不能取到

public class KSE07_18RoundF_CommonAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int i=1;
        while (i<=T){
            int L = sc.nextInt();
            String A = sc.next();
            String B = sc.next();
            int cnt = 0;
            // 预处理 B 字符串
            HashSet<String> BSortedSet = new HashSet<>();
            for(int p=0;p<L;p++){
                for (int q=p;q<L;q++){
                    char[] temp = B.substring(p,q+1).toCharArray();
                    Arrays.sort(temp);
                    BSortedSet.add(String.valueOf(temp));
                }
            }


            for (int j=0;j<L;j++){
                for(int k=j;k<L;k++){
                    boolean flag = false;
                    char[] charsOfA = A.substring(j,k+1).toCharArray();
                    Arrays.sort(charsOfA);
                    String temp = String.valueOf(charsOfA);
                    if (BSortedSet.contains(temp)){
                        cnt++;
                    }
                }
            }
            System.out.print("Case #"+i+": ");
            System.out.print(cnt + " ");
            System.out.println();
            i++;
        }
    }
}