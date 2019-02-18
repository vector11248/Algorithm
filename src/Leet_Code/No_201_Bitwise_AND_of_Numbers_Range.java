package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-02-15 20:37
 **/
public class No_201_Bitwise_AND_of_Numbers_Range {

    public static int rangeBitwiseAnd(int m, int n) {
       /* int ans  =  m;
        for(int i=m+1;i<=n;i++){
            ans &= i;
        }
        System.out.println(ans);
        return ans;*/
       //暴力会超时
        int cnt = 0;
        while (m!=n){
            m = m>>1;
            n = n>>1;
            cnt++;
        }
        return m<<cnt;
    }

    public static void main(String[] args) {
        //rangeBitwiseAnd(5,7);
       // int max = Integer.M;
        //System.out.println(max<<2);
    }


}
