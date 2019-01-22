package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-22 10:46
 **/
public class No_283_Move_Zeroes {

    public static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public void moveZeroes(int[] nums) {

        int length = nums.length;
        int i = 0;
        int j = 0;
        while (j < length){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        while (i<length){
            nums[i] = 0;
            i++;
        }
        return;
    }

}
