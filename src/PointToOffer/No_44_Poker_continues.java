package PointToOffer;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-03 12:46
 **/
public class No_44_Poker_continues {
    public static boolean isContinus(int[] nums){
        if (nums.length < 5) return false;
        int length = nums.length;
        int zero = 0; // 大小王
        int interval = 0; // 间距
        Arrays.sort(nums);
        for (int i = 0;i<length-1;i++){
            // 出现 0
            if (nums[i] == 0){
                zero++;
                continue;
            }if (nums[i]==nums[i+1]){
                // 出现对子，直接返回false
                return false;
            }
            interval += nums[i+1]-nums[i]-1;
        }
        return (interval <= zero) ? true :false;
    }

    public static void main(String[] args) {
        int[] testCase = {1,2,3,4,5};
        int[] testCase1 = {3,0,6,4,5};
        int[] testCase2 = {1,2,3,4,5};
        System.out.println(isContinus(testCase));
        System.out.println(isContinus(testCase1));
        System.out.println(isContinus(testCase2));
    }
}
