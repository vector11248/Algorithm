package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-08-16 08:11
 **/
public class ReverseNum {

    public static int reverseNum(int x){
        //  1234 --->4321
        //   12321 --->12321
        int res = 0;
        while (x != 0){
            res = (res * 10)+x%10;
            x /= 10;
        }
        return res;
    }


    public static boolean isPalindrome(int x) {
        if (x<0) return false;
        if (0<=x && x<=9) return true;
        if (x % 10 ==0 )return false;

        int res = 0;
        while (x > res){
            res = (res *10)+(x%10);
            x /= 10;
        }
        if(res == x || x==res/10){
            return true;
        }else return false;

    }

    public static void main(String[] args) {
        System.out.println(reverseNum(-10));
    }
}
