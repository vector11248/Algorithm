package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-26 10:47
 **/
public class No_264_Ugly_Number_II {
    public static int[] uglyNum = new int[1699];
    public static int index1 = 0; // *2
    public static int index2 = 0; // *3
    public static int index3 = 0; // *5
    public static int compare_value(int id1,int id2,int id3){
        int ans;
        if (uglyNum[id1] * 2<uglyNum[id2]*3){
            if (uglyNum[id1]*2 < uglyNum[id3]*5){
                ans = uglyNum[id1]*2;
                id1++;
            }else if (uglyNum[id1]*2 == uglyNum[id3]*5){
                ans = uglyNum[id1]*2;
                id1++;
                id3++;
            }else {
                ans = uglyNum[id3]*5;
                id3++;
            }
        }else if (uglyNum[id1]*2 == uglyNum[id2]*3){
            if (uglyNum[id1]*2 < uglyNum[id3]*5){
                ans = uglyNum[id1]*2;
                id1++;
                id2++;
            }else if (uglyNum[id1]*2 == uglyNum[id3]*5){
                ans = uglyNum[id1]*2;
                id1++;
                id2++;
                id3++;
            }else {
                ans = uglyNum[id3]*5;
                id3++;
            }
        }else {
            if (uglyNum[id2]*3 < uglyNum[id3]*5){
                ans = uglyNum[id2]*3;
                id2++;
            }else if (uglyNum[id2]*3 == uglyNum[id3]*5){
                ans = uglyNum[id2]*3;
                id2++;
                id3++;
            }else {
                ans = uglyNum[id3]*5;
                id3++;
            }
        }
        return ans;
    }

//    public static int nthUglyNumber(int n) {
//
//        uglyNum[0] = 1;
//        for (int i=1;i<n;i++){
//            uglyNum[i] = compare_value(index1,index2,index3);
//        }
//        return uglyNum[n-1];
//
//    }
    // 我这个代码写的太烂了，参考花花
    public static int nthUglyNumber(int n) {

        uglyNum[0] = 1;
        for (int i=1;i<n;i++){
            int next2 = uglyNum[index1]*2;
            int next3 = uglyNum[index2]*3;
            int next5 = uglyNum[index3]*5;
            int next  = Math.min(next2,Math.min(next3,next5));
            if (next == next2) index1++;
            if (next == next3) index2++;
            if (next == next5) index3++;
            uglyNum[i] = next;
        }
        return uglyNum[n-1];

    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
