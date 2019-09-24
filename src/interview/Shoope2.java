package interview;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-14 20:15
 **/
public class Shoope2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
//        System.out.println(1);
    }
    public static Boolean judge(String s1,String s2,int idx1,int idx2){
        // ? # *
        if (s1 == null || s2 == null){
            return false;
        }
        if (idx1 == s1.length()-1 && idx2 == s2.length()-1){
            return true;
        }

        if (idx1 != s1.length()-1 && idx2 == s2.length()){
            return false;
        }

        if (idx2 + 1< s2.length()-1 && s2.charAt(idx2+1) == '*'){
           if (idx1 != s1.length()-1 && s2.charAt(idx2+1)=='*'
                   || s2.charAt(idx2)=='?' && idx1 != s1.length()-1){
               return judge(s1,s2,idx1,idx2+2)
                       || judge(s1,s2,idx1+1,idx2+2)
                       || judge(s1,s2,idx1+1,idx2);
           }else {
               return judge(s1,s2,idx1,idx2+2);
           }
        }
        if (idx1 != s1.length()-1 && s2.charAt(idx2) == s1.charAt(idx1)
                || s2.charAt(idx2) =='.' && idx1 != s1.length()){
            return judge(s1,s2,idx1+1,idx2+1);
        }
        return false;



    }



}
