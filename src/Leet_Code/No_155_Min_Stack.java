package Leet_Code;

import java.util.Stack;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-03-08 19:54
 **/
public class No_155_Min_Stack {

    Stack s;
    Stack<Integer> s_data;
    Stack<Integer> s_min;
    /** initialize your data structure here. */
    public No_155_Min_Stack() {
        s_data = new Stack<>();// 数据栈
        s_min = new Stack<>(); // 辅助栈
    }

    public void push(int x) {
        s_data.push(x);
        if( !s_min.isEmpty()){
            s_min.push(Math.min(x,s_min.peek()));
        }
    }

    public void pop() {
        s_data.pop();
        s_min.pop();
    }

    public int top() {
        return s_data.pop();
    }

    public int getMin() {
        return s_min.peek();
    }
}
