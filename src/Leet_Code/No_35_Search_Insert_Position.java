package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-29 20:56
 **/
public class No_35_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {
        if (target<=nums[0]){
            return 0;
        }else if (target>nums[nums.length-1]){
            return nums.length;
        }else if (target==nums[nums.length-1]){
            return nums.length-1;
        }else {
            int lo = 0;
            int hi = nums.length-1;
            while(lo <= hi){
                int mid = lo + (hi-lo)/2;
                if (target == nums[mid]){
                    return mid;
                }else if (target < nums[mid]){
                    hi = mid-1;
                }else {
                    lo = mid + 1;
                }
            }
            return lo;
        }
    }

}
