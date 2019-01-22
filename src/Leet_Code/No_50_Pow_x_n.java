package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-11 14:15
 **/
public class No_50_Pow_x_n {
    private static double PowerUnsignedExponent(double base,int exponent){
        double result = 1.0;
        for (int i = 1;i<=exponent;i++){
            result *= base;
        }
        return result;
    }

    private static boolean equal(double num1,double num2){
        if ((num1 - num2) > - (1e-7) && (num1-num2) < (1e-7)){
            return true;
        }else {
            return false;
        }
    }

    private static double myPow(double x, int n) {
        int absN = (n>0)?n:-n;
        double result = PowerUnsignedExponent(x,absN);
        if (n<0){
            result = 1.0/result;
        }
        return result;
    }

    public static double pow(double x, int n) {
        // 递推 ---> 递归做的时间复杂度为logN

        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
            if(-n == Integer.MIN_VALUE){
                return x*pow(x,n-1);
            }
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }

    public static void main(String[] args) {
        System.out.println(pow(2.00000,-2147483648));
    }

}
