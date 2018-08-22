package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-08-21 08:55
 **/
public class ReverseInteger {
    public static int reverse(int x) {

        long  res=0;
        while (x != 0){

            //还有一种方法，不用long存储结果，
            // 该方法判断 res 与num / 10的大小

            res = (res * 10) + x%10;
            x /= 10;
        }
        if(res>Integer.MAX_VALUE){
            return 0;
        }
        return (int)res;


    }

    public static void main(String[] args) {

    }

}
