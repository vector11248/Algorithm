package Leet_Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-03-01 15:37
 **/
public class No_784_Letter_Case_Permutation {

    public static boolean isNum(char c){
        if ( c>='0' && c<='9'){
            return true;
        }
        return false;
    }

    public static boolean isLetter(char c){
        if ( (c>= 'a' && c<='z') || (c >='A' && c<='Z')){
            return true;
        }
        return false;
    }


    public static void backtrack(int pos,int length,List<String> res,char[] subAns,String S){
        // pos starts from 0
        if (pos >= length){
            res.add(new String(subAns));
            return;
        }
        if ( isNum(S.charAt(pos)) ){
            subAns[pos] = S.charAt(pos);
            backtrack(pos+1,length,res,subAns,S);
        }else if (isLetter(S.charAt(pos))){
            for (int i=0;i<2;i++){
                if (i==0){
                    // A
                    int temp;
                    if (S.charAt(pos) >= 'A' && S.charAt(pos) <= 'Z'){
                        temp = S.charAt(pos) - 'A';
                    }else {
                        temp = S.charAt(pos) - 'a';
                    }

                    subAns[pos] = (char)('A' + temp);
                    backtrack(pos+1,length,res,subAns,S);
                }else if (i == 1){
                    // a
                    int temp;
                    if (S.charAt(pos) >= 'A' && S.charAt(pos) <= 'Z'){
                        temp = S.charAt(pos) - 'A';
                    }else {
                        temp = S.charAt(pos) - 'a';
                    }

                    subAns[pos] = (char)('a' + temp);
                    backtrack(pos+1,length,res,subAns,S);
                }
            }
        }
        subAns[pos]='\0';

    }


    public static List<String> letterCasePermutation(String S) {
        if (S == null ) return null;
        List<String> res = new ArrayList<>();
        int n = S.length();
        char[] subAns = new char[n];
        backtrack(0,n,res,subAns,S);
        //System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(letterCasePermutation(""));
        int[] ints = {1,2,3};
    }
}
