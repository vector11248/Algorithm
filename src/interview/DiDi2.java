package interview;

import java.util.Scanner;
import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-08-27 20:08
 **/
public class DiDi2 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] nums = new int[n];
        String[] ops = new String[n-1];
        StringBuilder sb = new StringBuilder();
        for(int i=0,j=0,k=0;i<2*n+1;i++){
            if (i%2 == 0){
                // nums
                nums[j] = sc.nextInt();
                j++;
            }else {
                ops[k] = sc.next();
                k++;
            }
            sb.append(sc.next());

        }

        double res = getResult(operationExpressionToRPN(sb.toString()));
//        System.out.println(res);

        int[] arr = nums;
        List<String> res1 = new LinkedList<>();
        Arrays.sort(arr); // 直接用 Arrays.sort 对数组进行排序
//        List<String> s = helper(arr,res1);


//        String[] ss = helper(arr,res1);
        for (String s:helper(arr,res1)){
            StringBuilder temp = new StringBuilder();
            for(int i=1;i<s.length();i=+2){
                temp.insert(i,ops[i]);
            }
            if (getResult(operationExpressionToRPN(temp.toString())) == res){
                System.out.println(temp.toString());
            }
        }

    }

    /**
     * 根据后缀表达式计算结果集
     * @param result
     * @return
     */
    private static double getResult(List<String> result) {
        if (null == result || result.size() == 0) {
            throw new RuntimeException("表达式不合法！");
        }
        Stack<String> stack = new Stack<>();
        Set<String> operation = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        double d = 0.0d;
        for (String str : result) {
            if (!operation.contains(str)) {
                stack.push(str);
            } else {
                double up = Double.parseDouble(stack.pop());
                double down = Double.parseDouble(stack.pop());
                switch (str) {
                    case "+":
                        d = down + up;
                        break;
                    case "-":
                        d = down - up;
                        break;
                    case "*":
                        d = down * up;
                        break;
                    case "/":
                        d = down / up;
                        break;
                    default:
                        break;
                }
                stack.push(String.valueOf(d));
            }
        }
        return Double.parseDouble(stack.pop());
    }


    /**
     * 将中缀表达式转换为后缀表达式
     *
     * @param operationExpression
     * @return
     */
    private static List<String> operationExpressionToRPN(String operationExpression) {
        if (null == operationExpression || "".equals(operationExpression)) {
            throw new RuntimeException("表达式不合法！");
        }
        List<String> result = new LinkedList<>();

        char[] chars = operationExpression.toCharArray();

        Set<String> operation = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Set<String> numbers = new HashSet<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));


        Stack<String> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        String lastChar = "";
        for (char c : chars) {

            String currentChar = String.valueOf(c);

            // 上一个字符 和 当前字符 都是数字的话
            if (numbers.contains(lastChar) && numbers.contains(currentChar)) {
                String lastestChar = result.get(result.size() - 1);
                result.remove(result.size() - 1);
                result.add(lastestChar + currentChar);
                lastChar = currentChar;
                continue;
            }
            if (numbers.contains(currentChar)) {
                sb.append(currentChar);
            } else {
                /**
                 *
                 * 1：当前符号是 (, 则直接进栈
                 * 2：当前符号是 + - * /, 弹出所有优先级大于或者等于该运算符的栈顶元素，然后将该运算符入栈
                 * 3：当前符号是 ), 则把栈中的符号依次出栈，直到遇到 ）为止。
                 */

                if ("(".equals(currentChar)) {
                    stack.push(currentChar);
                } else if (operation.contains(currentChar)) {
                    /*while (true) {
                        // 栈空、栈顶符号为"("、当前符号优先级 > 栈顶符号优先级。当前符号入栈
                        if (stack.isEmpty() || getOperationLevel(stack.peek()) < getOperationLevel(currentChar) || "(".equals(stack.peek())) {
                            stack.push(currentChar);
                            break;
                        } else {
                            result.add(stack.pop());
                        }
                    }*/
                    while(!stack.isEmpty() && (getOperationLevel(stack.peek()) >= getOperationLevel(currentChar)) && !"(".equals(stack.peek())){
                        result.add(stack.pop());
                    }
                    stack.push(currentChar);
                } else if (")".equals(currentChar)) {
                    String str;
                    while (!stack.isEmpty() && !"(".equals(str = stack.pop())) {
                        result.add(str);
                    }
                }
            }

            if (!"".equals(sb.toString())) {
                result.add(sb.toString());
                sb.delete(0, sb.length());
            }
            lastChar = currentChar;
        }
        // 最后清空栈
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private static int getOperationLevel(String operation) {
        int result;
        switch (operation) {
            case "+":
                result = 1;
                break;
            case "-":
                result = 1;
                break;
            case "*":
                result = 2;
                break;
            case "/":
                result = 2;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }


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


}
