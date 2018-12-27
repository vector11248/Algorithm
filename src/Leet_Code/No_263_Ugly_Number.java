package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-26 10:05
 **/
public class No_263_Ugly_Number {

    public static boolean isPrime(int num){
        for (int i=2;i<Math.sqrt(num);i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }


    // 超时
//    public static boolean isUgly(int num) {
//        if (num < 1) return false;
//        if ( 1<num && num <7) return true;
//        for (int i = 7;i<=num;i++){
//            if (num%i==0 && isPrime(i)){
//                    return false;
//            }
//        }
//        return true;
//
//    }

    public static boolean isUgly(int num) {
        //  丑数 长啥样？
        // 2*2...* 2 *   3*3...*3*    5*5...*5;
        // m                n           p
        // （1）没有其他的因子，这是最后的分解形式
        // （2）m \ n \ p 不同时为0 即可
        if (num<1) return false;
        for (int i=2;i<6;i++){
            while (num%i == 0){
                num/=i;
            }
        }
        return num==1;

    }

    public static void main(String[] args) {
        System.out.println(isUgly(8));
    }

}
