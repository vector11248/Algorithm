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
        char[] test2 = {'b','b','a','a'};
        char[] test3 = {'a','b','c'};
        char[] test4 = {};

        System.out.println("1  "+firstNotRepeatChar(test1));
        System.out.println("2  "+firstNotRepeatChar(test2));
        System.out.println("3  "+firstNotRepeatChar(test3));
        System.out.println("4  "+firstNotRepeatChar(test4));

    }


}
