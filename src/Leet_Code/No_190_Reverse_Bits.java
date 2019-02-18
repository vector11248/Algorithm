package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-02-15 21:44
 **/
public class No_190_Reverse_Bits {

    public int reverseBits(int n) {
        // 这个题的核心还是说要把 n 的每一位通过右移抠出来， res的每一位通过左移塞进去
        int res = 0;
        for (int i=0;i<32;i++){
            res = res << 1;
            // 怎么扣呢？就是要通过n&1来搞。&1操作能够实现取出最后一位
            res += (n&1); // n&1 == n%2 实际是判断奇偶，奇数最后一位是1，偶数是0
            n = n>>1;
        }
        return res;
    }

}
