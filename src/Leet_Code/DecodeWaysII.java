package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-10 18:36
 **/
public class DecodeWaysII {

    public static void main(String[] args) {

        String ss  = "***";
        System.out.println( numDecodings(ss));
// 1 2 20               1 20        221 -->2 2 1 / 2  21  /  22 1/  3
//        12*                                  10  20
//                1 2 1/2/3.../9   9
//                12 1/2/3.../9 9



    }

    public static int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0:( s.charAt(0) == '*'? 9: 1);
        for(int i=2;i<=len;i++){

            if(s.charAt(i-1) != '0'){
                dp[i] = dp[i-1];

                if(s.charAt(i-1) == '*'){
                    dp[i] = dp[i-1]*9;
                    if(s.charAt(i-2) == '1'){
//                        dp[i] += dp[i-2] ;
//                        dp[i] *=  9;
                        dp[i] += 9;
                    }else if (s.charAt(i-2) == '2'){
//                        dp[i] += dp[i-2];
//                        dp[i] *= 6;\
                        dp[i] += 6;
                    }else if( s.charAt(i-2) == '*'){
//                        dp[i] += dp[i-2] ;
//                        dp[i] *= 15;
                        dp[i] += 15;
                    }
//                    else if (s.charAt(i-2) == '0'){
//                        dp[i] *= 9;
//                    }
                }else{
                    // 非 0 数字
                    if (s.charAt(i-2) == '*'){
                        if ( s.charAt(i-1) >= 1 && s.charAt(i-1) <= 6  ){
                            dp[i] += dp[i-2]+2;
                        }else {
                            dp[i] += dp[i-2]+1;
                        }
                    }else if(s.charAt(i-2) != '0' && s.charAt(i-2) != '*'){
                        int xy = (s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0');
                        if (xy >= 10 && xy <= 26){
                            dp[i] += dp[i-2];
                        }
                    }
                    // 前边是0的情况，可以略掉
                }

            }else {
                // 如果遇到0 ，只能看它前边是啥
                if (s.charAt(i-2) == '1' || s.charAt(i-2) == '2'){
                    dp[i] = dp[i-2];
                }else  if (s.charAt(i-2) == '*'){
                    dp[i] = dp[i-2] * 2;
                }
            }

        }

        return dp[len];
    }



}
