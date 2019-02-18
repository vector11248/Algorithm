package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-02-15 22:13
 **/
public class No_7_Reverse_Integer {

    public int reverse(int x) {

        int res = 0;
        while (x != 0){

            int tail = x%10;
            int newRes = res * 10 + tail;
            if ((newRes-tail)/10 !=res){
                return 0;
            }
            res = newRes;
            x = x/10;

        }
        return res;

    }

}
