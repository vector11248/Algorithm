package interview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Ctrip2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        StringBuilder sb = new StringBuilder();
        int[] resIdx = new int[expr.length()];
        Stack<Integer> stack =  new Stack<>();
        int length = expr.length();
        int index;
        for (int i=0;i<length;i++){
            if (expr.charAt(i) == '('){
                stack.push(i);
            }else if ( expr.charAt(i) == ')'){
                index = stack.pop();
                resIdx[i] = index;
                resIdx[index] = i;
            }
        }
        int cur = 0, dir = 1;
        while (cur != expr.length()){
            if (expr.charAt(cur) == '(' || expr.charAt(cur) == ')'){
                cur = resIdx[cur];
                dir = -dir;
                cur += dir;
            }else {
                sb.append(expr.charAt(cur));
                cur += dir;
            }
        }
        return sb.toString();

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
