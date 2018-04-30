/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-04-30 20:06
 **/
public class Leetcode821ShortestDistochar {
    public static void main(String[] args) {
        String s = "abaa";
        char c ='b';
        int[] pos = new int[s.length()+10];

        for (int i = 0; i < s.length(); i++) {
            int offset = 0;
            while ((i+offset<s.length())&&s.charAt(i+offset)!=c){
                offset++;
            }
            if(i+offset == s.length()){
                pos[i]=9999999;
            }else{
                pos[i]=offset;
            }
        }
        for (int i = s.length()-1; i >0 ; i--) {
            int offset = 0;
            while ((i-offset>-1)&& s.charAt(i-offset)!=c) {
                offset++;
            }
            if(i-offset == -1){
                offset = 99999999;

            }
            pos[i]=Math.min(pos[i],offset);


        }


        for (int i = 0; i < s.length(); i++) {
            System.out.println(pos[i]);
        }
    }
}
