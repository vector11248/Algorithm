package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-21 19:56
 **/
public class No_268_Missing_Number {
    public int missingNumber(int[] nums) {
        boolean[] in = new boolean[nums.length];
        for (int i=0;i<nums.length;i++){
            in[i] = true;
        }
        int i;
        for ( i=0;i<in.length-1;i++){
            if (in[i]==false){
                break;
            }
        }
        return i;
    }
}
