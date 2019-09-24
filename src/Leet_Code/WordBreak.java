package Leet_Code;

import java.util.HashSet;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-06 10:08
 **/
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1]; // dp[i] 代表以字符串s中第i位结尾的子串，是否在能被word break,右侧开区间不包括i
        dp[0] = true;// 初始值，以第0位能够被word所 break
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                String temp = s.substring(j,i);
                if (dp[j] && wordDict.contains(temp)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {

    }
}
