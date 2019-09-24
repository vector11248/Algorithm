package interview;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-04 20:40
 **/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Ctrip3 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m,int[] array) {

        int n = array.length;
        List<Integer> sums = new ArrayList<>();
        for (int i = 0;i<n-1;i++){
            sums.set(i,array[i]+array[i+1]);
        }
        List nums = Arrays.asList(array);
        while (n>m){
            int index = 0, min_sum = Integer.MIN_VALUE;
            for(int i=0;i<sums.size();i++){
                if (min_sum > sums.get(i)){
                    min_sum = sums.get(i);
                    index = i;
                }
            }
            if (index != 0){
//                sums.set(index-1, sums.get(index-1) + array[index + 1]);
                sums.set(index-1, sums.get(index-1) + (int)nums.get(index+1));
            }
            if( index !=  sums.size() - 1){
//                sums.set(index+1, sums.get(index+1) + array[index]);
                sums.set(index+1, sums.get(index+1) + (int)nums.get(index));
            }
            sums.remove(index);
            nums.remove(index+1);
            nums.set(index,min_sum);
            sums.set(index,min_sum + (int)nums.get(index+1));

        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            if (res < (int)nums.get(i)){
                res = (int)nums.get(i);
            }
        }

        return res;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}
