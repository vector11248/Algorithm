package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-06-28 21:46
 **/

/*
   0.开头遇到空格就舍弃，直到遇到第一个非空格符
*  1.第一个非空格符只能以 +、-、或者直接以数字字符开始，直到第一个非数字字符 结束。其后的字符直接舍弃
*  2.如果是以其他开头的，则无效。
*  3。若只有空格符号、字符串为空，则无效
*  4。所有无效的最后返回 0
*  5。超出Int 范围的返回Int的最大值或者最小值
*
* */






public class ATOI {
    public static int atoi(String s){
        long ret = 0;
        boolean negative = false;
        boolean started = false;//是否已经开始遇到数字了
        int limit = Integer.MAX_VALUE;

        for(int i=0;i<s.length();i++){
            if(' '==s.charAt(i)){
                if(!started){
                    continue;
                }else break;
            }else if (s.charAt(i)=='+'){
                if(!started){
                    negative = false;
                    started = true;
                    continue;
                }else break;

            }else if(s.charAt(i)=='-'){
                if(!started){
                    negative =true;
                    started = true;
                    continue;
                }else break;
            }else if(s.charAt(i)>='0' && s.charAt(i)<='9' ){
                if(!started){
                    started = true;
                }
                ret = ret * 10 + (s.charAt(i)-'0');
                if(ret>limit){
                    return ( negative? Integer.MIN_VALUE:Integer.MAX_VALUE );
                }
            }else
                break;
        }



        return (int) (negative?-ret:ret)   ;
    }


    public static void main(String[] args) {
        String s = "d   123  dd";

        System.out.println(atoi(s));

    }
}
