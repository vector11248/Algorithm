package Leet_Code;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-25 22:43
 **/
public class Test {

    public static void changeInt(List<String> ans){
        ans.add("hello");
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = nums[i];
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(3);

        Set set = new HashSet<>();
        set.add(list1);
        set.add(list2);
        System.out.println(set);
    }
}
