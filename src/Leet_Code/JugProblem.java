package Leet_Code;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-11 10:14
 **/
public class JugProblem {

    public static void main(String[] args) {

//        HashMap<Pair,Boolean> map = new HashMap<>();
        System.out.println(BFS(2,6,5));

    }

    public static class Pair{
        int x,y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "("+x+","+y+")";
        }
    }

    public static boolean BFS(int a,int b,int target){
//        HashMap< List<Integer>,Boolean > map = new HashMap<>();
//        List<Integer> init = new ArrayList<>();
//        init.add(0);
//        init.add(0);
//        map.put(init,true);
//
//        boolean isSolvable = false;
//        List<List<Integer>> path = new LinkedList<>();
        HashMap<Pair,Boolean> map = new HashMap<>();
        boolean isSolvable = false;
        LinkedList<Pair> path = new LinkedList<>();

        Queue<Pair> queue = new LinkedList<>();
        ((LinkedList<Pair>) queue).push(new Pair(0,0));

        while (!queue.isEmpty()){
            // peek 是获取首元素，poll 是获取并移除首元素
            Pair cur = queue.peek(); // 当前元素
            queue.poll();

//            System.out.println(cur);
            // 已经访问过来
            if (map.get(cur)!=null && map.get(cur)){
                continue;
            }

            // 不符合容量限制
            if ((cur != null) && (cur.x > a || cur.y >b || cur.x <0 || cur.y <0)){
                continue;
            }

            // 放入路径
            path.add(cur);
            // 标记已经被访问过
            map.put(cur,true);

            // 找到了
            if (cur.x == target || cur.y == target){
                isSolvable = true;
                if (cur.x == target){
                    if (cur.y != 0){
                        path.add(new Pair(cur.x,0));
                    }
                }else {
                    if (cur.x != 0){
                        path.add(new Pair(0,cur.y));
                    }
                }
                // 打印路径
                System.out.println(path);
                break;
            }

            // 如果没有找到，那么就得找以下的几种操作了
            // (1,2) 分别填满 a,b
            //  1--> 2 || 2-->1 相互倒
            //  a, b 都把其倒掉

            ((LinkedList<Pair>) queue).add(new Pair(cur.x,b));
            ((LinkedList<Pair>) queue).add(new Pair(a,cur.y));
            for(int amount = 1;amount<= Math.max(a,b);amount++){
                // 1---> 2
                int c = cur.x - amount;
                int d = cur.y + amount;

                if ((c == 0 && c >= 0) || d == b){
                    ((LinkedList<Pair>) queue).add(new Pair(c,d));
                }

                // 2---> 1
                c = cur.x + amount;
                d = cur.y - amount;
                if ( (d==0 && d>=0 )|| c == a){
                    ((LinkedList<Pair>) queue).add(new Pair(c,d));
                }
            }

            ((LinkedList<Pair>) queue).add(new Pair(cur.x,0));
            ((LinkedList<Pair>) queue).add(new Pair(0,cur.y));

        }


        return isSolvable;

    }

}
