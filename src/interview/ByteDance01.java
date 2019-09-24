package interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-22 08:17
 **/
public class ByteDance01 {
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // n 个数
        char[] arr = new char[N];
        String input = sc.next();
        arr = input.toCharArray();
        int[] dis = new int[N];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            if (arr[i]=='O'){
                dis[i] = 0;
                q.offer(i);
            }else {
                dis[i] = Integer.MAX_VALUE;
            }
        }

        while (!q.isEmpty()){
            int node = q.peek();
            q.poll();
            if (node-1>=0){
                if (dis[node-1] > dis[node] + 1 ){
                    dis[node-1] = dis[node]+1;
                    q.offer(node-1);
                }

            }
            if (node+1<N){
                if (dis[node+1] > dis[node] + 1){
                    dis[node+1] = dis[node]+1;
                    q.offer(node+1);
                }
            }
        }
        for(int i=0;i<N;i++){
            System.out.print(dis[i] + " ");
        }




    }
}
