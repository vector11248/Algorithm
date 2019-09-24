package Test;


import java.util.HashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-16 11:46
 **/
public class Test1 {
    public static void main(String[] args) {
        HashSet<String> BSortedSet = new HashSet<>();
        char[] a1 = {'A','B'};
        char[] a2 = {'A','B'};
        String s = String.valueOf(a1);
        String s1 = String.valueOf(a2);
        BSortedSet.add(s);
        BSortedSet.add(s1);
        System.out.println(BSortedSet);


    }
}
