package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-02-18 09:35
 **/
public class No_397_Integer_Replacement {
    public int integerReplacement(int n) {
        long t = n;
        int cnt = 0;
        while (n!=1){
            if((n&1)==1){
                // 奇数
                // 如果一个数加1之后是4的倍数，就让他加一；其他情况减一即可。
                // 如何判断一个数加一后是4的倍数呢？奇数最后一位是1，如果倒数第二位也是1，则加一即为4的倍数。
                // 3、7除外
                if((n&2)==2 && n!=3){
                    n = n+1;
                }else {
                    n = n-1;
                }
                cnt++;
            }else {
                // 偶数
                cnt++;
                n/=2;
            }
        }
        return cnt;
    }
}
