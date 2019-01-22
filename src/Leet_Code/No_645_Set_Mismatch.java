package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-22 17:21
 **/
public class No_645_Set_Mismatch {

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        if (n == 0) return res;
        boolean[] in = new boolean[n+1];
        for (int i=0;i<n;i++){
            if (in[nums[i]] == true ){
                res[0] = nums[i];
                //break;
            }else {
                in[nums[i]] = true;
            }
        }
        for (int i=1;i<=n;i++){
            if (in[i]==false){
                res[1] = i;
            }
        }
        return res;
    }


}
