package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-27 18:52
 **/
public class No_704_Binary_Search {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            if (target > nums[mid]){
                lo = mid+1;
            }else if (target < nums[mid]){
                hi = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
