package Leet_Code;

import java.util.Arrays;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-18 18:53
 **/
public class No_120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        int[] sum = new int[triangle.get(triangle.size()-1).size()+1];
        sum[0] = triangle.get(0).get(0);
        for (int i = 1;i<triangle.size();i++){

            int last = triangle.get(i).size()-1;
            //System.out.println("*****: last is: " + last);
            //System.out.println("*****: last is: " + sum[last-1]);
            sum[last] = sum[last-1]+triangle.get(i).get(last);
            //System.out.println("*****: sum last is: " + sum[last]);
            for (int j=triangle.get(i).size()-2;j>0;j--){
                sum[j] = Math.min(sum[j-1],sum[j]) + triangle.get(i).get(j);
            }
            sum[0] = sum[0] + triangle.get(i).get(0);
        }
        int min=sum[0];
        for (int i=1;i<sum.length-1;i++){
            if (sum[i]<min){
                min = sum[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
       //List<List<Integer>> triangle = [[2],[3,4],[6,5,7],[4,1,8,3]];
        //System.out.println();
    }
}
