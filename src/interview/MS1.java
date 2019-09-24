package interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-22 20:02
 **/
public class MS1 {

    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String[] arr = new String[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.next();
        }
        HashSet<String> set =new HashSet<>();
        for(int i=0;i<N;i++){
            StringBuilder sb = new StringBuilder();
            int len = (arr[i].length() %2 == 0) ? arr[i].length()/2:arr[i].length()/2+1;
            char[] a = new char[len];
            for(int k=0,ii =0;k<arr[i].length();k+=2,ii++){
                a[ii] = arr[i].charAt(k);
            }
            Arrays.sort(a);
            sb.append(String.valueOf(a));
            char[] b = new char[arr[i].length()/2];
            for(int k=1,jj=0;k<arr[i].length();k+=2,jj++){
                b[jj] = arr[i].charAt(k);
            }
            Arrays.sort(b);
            sb.append(String.valueOf(b));
            set.add(sb.toString());
            System.out.println("000:"+ sb.toString());
        }

        System.out.println(set.size());
    }

}
