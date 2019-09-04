package interview.NetEase;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-08-03 14:39
 **/
public class Class1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt(); // n个人
            int[] arr = new int[n+1];
            List<Integer> stus = new LinkedList<>();
            for(int i=0;i<n;i++){
                arr[i] = in.nextInt();
                stus.add(arr[i]);
            }
            Collections.sort(stus);
            int q = in.nextInt();
            int[] query = new int[q+1];
            for(int i=0;i<q;i++){
                query[i] = in.nextInt();
            }
//            int cnt = stus.lastIndexOf();
            HashMap<Integer,Integer> map = new HashMap<>();
            for (Integer i : stus) {
                map.put(i,stus.lastIndexOf(i)+1);
            }
            for (int i=0;i<q;i++){
               // System.out.println( (map.get(arr[query[i]-1])-1) / n );
                int s=map.get(arr[query[i]-1]);
                double res = (s-1)*100.0/n;
                String sss = String.format("%.6f",res);
                System.out.println(res);
            }
        }

    }
}
