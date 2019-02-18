package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-14 22:02
 **/
public class No_152_Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {

        int length = nums.length;
        if (length == 0) return 0;
        int maxProduct = nums[0];
        int minProduct = nums[0];
        for (int i = 1;i<length;i++){
            maxProduct = Math.max(Math.max(maxProduct*nums[i],minProduct*nums[i]),nums[i]);
            minProduct = Math.min(Math.min(maxProduct*nums[i],minProduct*nums[i]),nums[i]);
        }

        return maxProduct;

        //return Math.max(maxProduct,minProduct);
    }
}
