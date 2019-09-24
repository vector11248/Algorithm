package interview;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-11 20:03
 **/
public class Xiaomi2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String solution(String[] input) {
        if (input == null)
            return "";
        int l = input.length;
        int[][] arr = new int[l][l];
        int[] AddZero = new int[l];

        for (int i = 0; i < l; i++) {
            String[] split = input[i].split(" ");
            for(int j = 0; j < l; j++) {
                int num = Integer.parseInt(split[j]);
                if (num == 0)
                    AddZero[i] ++;
                arr[i][j] = num;
            }
        }


        for (int i = 0; i < l; i++) {
            for(int j = 0; j + 1 < l; j++) {
                if (arr[i][j] == arr[i][j+1] && arr[i][j] != 0) {
                    arr[i][j] +=  arr[i][j];
                    arr[i][j+1] = 0;
                    AddZero[i]++;
                }
            }
        }


        int[][] res = new int[l][l];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < l; i++) {
            int m = 0;
            for (int j = 0; j < l; j++) {
                if (arr[i][j] != 0) {
                    res[i][m++] = arr[i][j];
                }
            }
        }


        for (int i = 0; i < l; i++) {
            for (int j = 0; j  < l; j++) {
                if (j == 0) {
                    sb.append(String.valueOf(res[i][j]));
                } else {
                    sb.append(" " + String.valueOf(res[i][j]));
                }
            }
            if (i != l-1) {
                sb.append('\n');
            }
        }

        return sb.toString();



    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = solution(_input);
        System.out.println(res);
    }
}
