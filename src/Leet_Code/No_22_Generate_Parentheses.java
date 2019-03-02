package Leet_Code;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-02-28 14:57
 **/
public class No_22_Generate_Parentheses {

    static List<String> res = new ArrayList<>();
//    private static String[] s= {"(",")"};
    private static char[] s= {'(',')'};

    public  static void backtrack(int pos,int n,char[] sb,int l,int r){
        // n node, 2n pos. pos represent the position in the string
        // pos start from 1
        // l/r 分别代表左右括号的个数，其中最重要的判断条件是 右括号的数量不能比左括号的数量多。
        if (pos > 2*n){
            String s = new String(sb);
            res.add(s);
            return;
        }
        for(int i=0;i<2;i++){
            // i=0 --> (
            // i=1 --> )
            //sb.append(s[i]);
            if(s[i]=='(') l++;
            else if (s[i]==')'){
                r++;
                l--;
            }
            if ( l>=r && l<=n && r<=n  && (pos>0 && pos<=2*n)  ){
                        //sb.append(s[i]);
                        //sb.insert(pos-1,s[i]);
                        //sb.setCharAt(pos-1,s[i]);
                        sb[pos-1] = s[i];
                        backtrack(pos+1,n,sb,l,r);
            }
//            else {
//                if(s[i]=='(') l--;
//                else if (s[i]==')') r--;
//            }

        }
        //sb.deleteCharAt(pos-1);
        sb[pos-1] = '\0';
    }


    public static List<String> generateParenthesis(int n) {
        if (n ==0 ) return null;
        //StringBuilder sb = new StringBuilder();
        //boolean[] flag = new boolean[2*n+1];
        char[] sb = new char[n*2];
        backtrack(1,n,sb,0,0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));

        /*StringBuilder sb = new StringBuilder();
        sb.setCharAt(0,'a');
        sb.setCharAt(1,'b');
        System.out.println(sb);*/

    }

}
