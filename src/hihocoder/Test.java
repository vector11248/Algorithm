package hihocoder;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-03-09 15:27
 **/
public class Test {

    public static void main(String[] args) {
        String s= "A<B<=E";
        String[] res = s.split("<");
        for(String s1:res){
            System.out.println(s1+"     ");
        }
    }
}
