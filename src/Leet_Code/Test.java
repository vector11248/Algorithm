package Leet_Code;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-25 22:43
 **/
public class Test {

    public static boolean match(char[] str, char[] pattern)
    {
        int sindex = 0, pindex = 0;
        return matchCore(str, sindex, pindex, pattern);
    }
    public static boolean matchCore(char[] str, int sindex, int pindex, char[] pattern){
//        if(sindex >= str.length && pindex == pattern.length)
//            return true;
//        if(pindex >= pattern.length && sindex < str.length)
//            return false;
        if(sindex == str.length && pindex == pattern.length)
            return true;
        if(sindex >= str.length && pindex < pattern.length ||
                sindex < str.length && pindex >= pattern.length)
            return false;
        if(pindex+1 < pattern.length && pattern[pindex+1] == '*'){
            if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.') ){
                return matchCore(str, sindex, pindex+2, pattern) ||
                        matchCore(str, sindex+1, pindex+2, pattern ) ||
                        matchCore(str, sindex+1, pindex, pattern);
            }else{
                return matchCore(str, sindex, pindex+2, pattern);
            }
        }
        if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.'))
            return matchCore(str, sindex+1, pindex+1, pattern);
        return false;
    }


    public static void main(String[] args) {

        char[] str = {'a','a','a'};
        char[] pattern = {'a','*'};
        System.out.println(match(str,pattern));
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
    }
}
