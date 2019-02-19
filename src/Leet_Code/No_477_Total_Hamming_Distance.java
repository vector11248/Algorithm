package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-02-19 10:58
 **/
public class No_477_Total_Hamming_Distance {

    public static int hammingDistance(int x, int y) {
        int dist = 0;
        int val = x^y;
        while (val!=0){
            dist++;
            val &= val-1;
        }
        return dist;
    }
    public int totalHammingDistance(int[] nums) {
        /*int len = nums.length;
        if (nums == null || len==0){
            return 0;
        }
        int total = 0;
        for (int i=0;i<len;i++){
            for (int j=i;j<len;j++){
                total += hammingDistance(nums[i],nums[j]);
            }
        }
        return total;
        */
        // 效率太低，垃圾
        int total = 0;
        int n = nums.length;
        for (int i=0;i<32;i++){
            int numOfOne = 0;
            for (int num:nums){
                if ( ( ( num >> i) & 1 ) != 0  ){
                    numOfOne ++;
                }
            }
            total += numOfOne * (n - numOfOne);
        }
        return total;





    }


}
