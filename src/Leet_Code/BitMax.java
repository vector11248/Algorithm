package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-25 11:58
 **/
public class BitMax {
    public static int flip(int n){
        // n取0 或 1。若取其他数，则只会翻转最后一位。
        return n^1;
    }

    public static int sign(int n){
        // 取一个32位整数的符号
        // 此处用到了flip翻转操作。
        // 负数 1:  1-->0
        // 非负数： 0 : 0--->1
        return flip((n>>31) & 1);
    }

    public static int getMax(int a,int b){
        int c = a-b;
        int scA = sign(c);
        int scB = flip(scA);
        return a*scA + b*scB;
    }

    public static int getMax2(int a,int b){
        int c = a-b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        int difab = sa^sb;
        int sameab = flip(difab);

        int returnA = difab * sa + sameab * sc;
        int returnB = flip(returnA);

        return a*returnA + b*returnB;

    }



    public static void main(String[] args) {
        System.out.println(getMax2(3,9));
        System.out.println(getMax2(3,-9));
        System.out.println(getMax2(3,0));
        System.out.println(getMax2(0,0));
    }

}
