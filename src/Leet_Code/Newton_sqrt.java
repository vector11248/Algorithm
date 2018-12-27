package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-27 10:16
 **/
public class Newton_sqrt {

    public static double sqrt_newton(double c){
        if (c < 0 ) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (Math.abs(t-c/t) > err*t){
            t=(c/t + t)/2.0;
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(sqrt_newton(3));
    }
}
