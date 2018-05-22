package L4_Heap;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-05-22 09:53
 **/
public class Kth_largest {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        PriorityQueue<Integer> pq  = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
//        System.out.println(pq.size());
        for (int n:nums){
            pq.add(n);
        }
//        System.out.println(pq.size());
        for(int i=0;i<k-1;i++){
            pq.poll();
        }
        System.out.println(pq.poll());

        int kk = 25;
        System.out.println("K>>1: ");
        System.out.println(kk>>1);
        System.out.println(kk<<1);
        System.out.println(kk>>>1);
//        System.out.println(kk<<<1);

    }
}
