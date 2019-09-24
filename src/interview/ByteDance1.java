package interview;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-08 20:16
 **/
public class ByteDance1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<List<String>> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            List<String> cur = new ArrayList<>();
            int n = s.charAt(i) - '0';
            if(i == 0) {
                cur.add(String.valueOf((char)(n + 'A' - 1)));
            } else {
                if(n != 0) {
                    for (String tmp : list.get(i - 1)) {
                        cur.add(tmp + String.valueOf((char) (n + 'A' - 1)));
                    }
                }
                int last = s.charAt(i - 1) - '0';
                if(last == 1 || (last == 2 && n <= 6)) {
                    String c = String.valueOf((char)(last * 10 + n + 'A' - 1));
                    if(i == 1)
                        cur.add(c);
                    else {
                        for(String tmp : list.get(i - 2)) {
                            cur.add(tmp + c);
                        }
                    }
                }
            }
            list.add(cur);
        }
        List<String> ans = list.get(s.length() - 1);
        Collections.sort(ans);
        for(String tmp : ans) {
            System.out.println(tmp);
        }
    }


//    public List<String> dfs(String nums){
//        List<String> res = new LinkedList<>();
//
//    }


}
