package Template;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-08-05 22:37
 **/
public class Permutation {

    public static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void dfs(int[] arr,int index,List<String> res){
        int n = arr.length;
        if ( index == n-1 ){
            StringBuilder sb = new StringBuilder();
            for (int num:arr) {
                sb.append(num + " - ");
            }
            res.add(sb.toString());
        }
        for (int i=index;i<n;i++){
            if (index !=i && arr[index] == arr[i]){
                continue;
            }
            swap(arr,i,index);
            dfs(arr,i+1,res);
        }
    }


    public static List<String> helper(int[] arr,List<String> res){
        if (arr == null || arr.length == 0){
            return null;
        }
        dfs(arr,0,res);
        return res;
    }



    public static void main(String[] args) {
        int[] arr = {4,5,3,9,8};
        List<String> res = new LinkedList<>();
        Arrays.sort(arr); // 直接用 Arrays.sort 对数组进行排序
        for (String s:helper(arr,res)){
            System.out.println(s);
        }


    }
}

