package interview;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-25 19:27
 **/
public class Huawei3 {

    public static void main(String[] args) {
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int res = 0;
            int max = 0;
            Stack<Integer> numStack = new Stack<>();
            Stack<Integer> tempStack = new Stack<>();
            numStack.push(arr[0]);

            for(int i=1;i<n;i++){
                while (!numStack.isEmpty() && numStack.peek() > arr[i]){
                    int temp = numStack.pop();
                    res -= 1;
                    tempStack.push(temp);
                }
                if (numStack.isEmpty()){
                    numStack.push(arr[i]);
//                    res += 1;
                    while (!tempStack.isEmpty()){
                        numStack.push(tempStack.pop());
                    }
                }else{
                    if (numStack.peek() == arr[i]){
                        while (numStack.peek() == arr[i]){
                            tempStack.push(numStack.pop());
                        }
//                        numStack.pop();
                        res += numStack.size();
                        while (!tempStack.isEmpty()){
                            numStack.push(tempStack.pop());
                        }
                        //continue;
                    }
                     else{
                        res += numStack.size();
                        numStack.push(arr[i]);
                        while (!tempStack.isEmpty()){
                            numStack.push(tempStack.pop());
                        }
                    }
                }


                if (res > max){
                    max = res;
                }

            }
            System.out.print(max);
            System.out.print(" ");
            System.out.print(res);
            System.out.println();

        }
    }

}
