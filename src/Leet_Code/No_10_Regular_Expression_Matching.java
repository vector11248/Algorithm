package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-14 14:59
 **/
public class No_10_Regular_Expression_Matching {

    public static boolean isMatch(String s, String p) {
        boolean[][] T = new boolean[s.length()+1][p.length()+1];
        T[0][0] = true;
        for (int i = 1;i<T[0].length;i++){
            if (p.charAt(i-1)=='*'){
                // a* b * c * ,这种 空字符串s 是可以匹配的
                T[0][i] = T[0][i-2];

            }
        }

        for (int i=1;i<T.length;i++){
            for (int j = 1;j<T[0].length;j++){

                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                    T[i][j] = T[i-1][j-1];
                }else if (p.charAt(j-1)=='*'){
                    T[i][j] = T[i][j-2]; // *之前的元素出现0次，则直接看s.当前能否与p抹去*前的a 是否匹配

                    // 第二种情况，p前一个元素可以与当前s匹配，则去掉s的当前，看之前的s与当前的p能够匹配
                    if (p.charAt(j-2)=='.' || s.charAt(i-1)==p.charAt(j-2)){
                        // 两种情况取或即可
                        T[i][j] = T[i][j] || T[i-1][j];
                    }

                }else {
                    T[i][j] = false;
                }
            }
        }
        return T[s.length()][p.length()];


    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
    }

}
