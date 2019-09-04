package interview.NetEase;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-08-03 16:11
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t>0){
            int n = in.nextInt();
//            int[] arr = new int[n+1];
            List<Long> list = new LinkedList<>();
            for(int i=0;i<n;i++){
                list.add(in.nextLong() );
            }
            Collections.sort(list);
            if (list.get(n-1) < list.get(n-2) + list.get(n-3)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

            t--;
        }
        return;
    }
}
