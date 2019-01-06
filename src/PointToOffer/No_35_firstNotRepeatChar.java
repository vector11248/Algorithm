package PointToOffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-05 15:38
 **/
public class No_35_firstNotRepeatChar {
    // 给定一个字符串，返回第一个不重复的char
    public static char firstNotRepeatChar(char[] string){
        // 数组为空
        if (string.length == 0) return ' ';
        int n = string.length;
        // LinkedHashMap 是按照key放入的顺序来存的，取的时候有顺序性
        Map<Character,Integer> map = new LinkedHashMap<>();

        for (int i = 0;i<n;i++){
            if (!map.containsKey(string[i])){
                map.put(string[i],1);
            }else {
                map.put(string[i],map.get(string[i])+1);
            }
        }

        for (Character ch : map.keySet()){
            if (map.get(ch) == 1){
                return ch;
            }
        }
        return ' ';


    }

    public static char[] Cover2thStr(char[] str1,char[] str2,char[] newstr){
        // 在第一个字符串中删除掉在第二个字符串当中出现过的字符。
        if (str2.length == 0) return str1;
        Map<Character,Integer> map = new LinkedHashMap<>();
        int n1 = str1.length;
        int n2 = str2.length;
        for (int i=0;i<n2;i++){
            if (!map.containsKey(str2[i])){
                map.put(str2[i],1); // 1实际上无意义，只要在str2当中出现的，全部放到map中
            }
        }
        int i = 0;
        int j = 0;
        while (i<n1){
            if (!map.containsKey(str1[i])){
                newstr[j] = str1[i];
                i++;j++;
            }else {
                i++;
            }
        }
        return newstr;
    }



    public static void main(String[] args) {
       // 测试用例：
        /*
              功能测试：
        *   （1） 存在只出现一次的字符
        *   （2） 不存在只出现一次的字符。即每个字符至少出现两次
        *   （3） 全部字符均出现1次，返回第一个。
        *     特殊测试输入
        *   （4） 输入为空
        * */

        char[] test1={'b','b','a','c','a'};
        char[] test2={'d'};
//        char[] test2={};
//        char[] test2 = {'b','c','a','a'};
//        char[] test3 = {'a','b','c'};
//        char[] test4 = {'中'};
//        char[] test5 = {'a'};
//        System.out.println(test1);
//        System.out.println("1  "+firstNotRepeatChar(test1));
//        System.out.println("2  "+firstNotRepeatChar(test2));
//        System.out.println("3  "+firstNotRepeatChar(test3));
//        System.out.println("4  "+firstNotRepeatChar(test4));
//        System.out.println(test4);
//        System.out.println(test5.length);

        char[] newstr = new char[test1.length];
        System.out.println(Cover2thStr(test1,test2,newstr));

    }


}
