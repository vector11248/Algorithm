package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-22 11:28
 **/
public class No_27_Remove_Element {

    public static int removeElement1(int[] nums, int val) {
        int length = nums.length;
        if (length == 0) return 0;
        int i=0;
        int j=0;
        while (j<length){
            if (nums[j] != val){
                nums[i++] = nums[j++];
            }else {
                j++;
            }
        }
        return i;

    }
    // 上述方法比较慢，原因是 我们的代码中，凡是不==val，都要进行一次复制操作。
    //  那么，我们能不能进行改进呢？对于nums而言，==val的值还是少数，
    // 所以，我们要遇到==val的才进行操作，由于题目不要求新数组的顺序。
    public static int removeElement(int[] nums,int val){
        int length = nums.length;
        int i = 0;
        while (i<length){
            if(nums[i]==val){
                nums[i] = nums[length-1];
                length--;
            }else {
                i++;
            }
        }
        return length;
    }



    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(removeElement1(nums,2));
    }

}
