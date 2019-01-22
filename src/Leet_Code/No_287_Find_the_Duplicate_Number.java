package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-22 16:59
 **/
public class No_287_Find_the_Duplicate_Number {

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        boolean[] in = new boolean[n-1];
        int ans = 0;
        for (int i=0;i<n;i++){
            if (in[nums[i]] == true ){
                ans = nums[i];
            }else {
                in[nums[i]] = true;
            }
        }

        return ans;
    }

}
