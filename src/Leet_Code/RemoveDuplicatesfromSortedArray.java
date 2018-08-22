package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-08-22 08:53
 **/
public class RemoveDuplicatesfromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int i=0;
        for(int j=1;j<=nums.length-1;j++){
            if(nums[i]<nums[j]){
                nums[++i] = nums[j];
            }
        }
        return i+1;

    }

    public static int removeDuplicates2(int[] nums) {
        if(nums.length == 1) return 1;
        int i=0;
        int repeat=1;
        for(int j=1;j<=nums.length-1;j++){
            if(nums[i]<nums[j]){
                nums[++i] = nums[j];
                repeat = 1;
            }else if(nums[i] == nums[j]){
                repeat++;
                if(repeat <=2 ){
                    i++;
                    nums[i] = nums[j];
                }
                // repeat > 2 ，则直接略过就好

            }
        }
        return i+1;

    }



        public static void main(String[] args) {

    }

}
