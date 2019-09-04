package Leet_Code;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-07-31 21:43
 **/
public class No_752_Open_the_Lock {

    public static int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends)); // 死亡集合
        if (dead.contains("0000")){
            return -1;
        }
        if (target.equals("0000")){
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        ((LinkedList<String>) queue).offer("0000");
        int res = 1; // bfs , represent the step
        while (!queue.isEmpty()){
            for (int n = queue.size();n>0;n--){
                String cur = ((LinkedList<String>) queue).poll();
                for (int i=0;i<4;i++){
                    // 一共 4 位
                    for (int dif = 1;dif<=9;dif += 8){
                        // + 1 ,- 1 这个操作比较神奇。
                        StringBuilder sb = new StringBuilder(cur);
                        sb.setCharAt(i, (char) ((sb.charAt(i)-'0'+dif) % 10 + '0') );
                        if (sb.toString().equals(target)){
                            return res;
                        }
                        if (!dead.contains(sb.toString()) && !visited.contains(sb.toString())){
                            ((LinkedList<String>) queue).push(sb.toString());
                        }
                    }
                }
            }
            res++;
        }
        return -1;

    }
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println("hello");
        System.out.println(openLock(deadends,target));
    }

}
