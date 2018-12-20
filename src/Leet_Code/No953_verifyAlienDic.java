package Leet_Code;

import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-18 13:31
 **/
public class No953_verifyAlienDic {


    // 核心思想是利用  比较大小时的传递性，a>= b, b>= c,则a>=c，所以只需要两两比较即可。
    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(order.charAt(i),i);
        }

        // 开始比较字符串数组里的元素。
        // 找到  第一个  不一样  的元素比较大小
        for (int i = 0; i < words.length-1 ; i++) {
            String a = words[i];
            String b = words[i+1];
            int j;
            for ( j = 0; j < Math.min(a.length(),b.length()); j++) {
                if (map.get(a.charAt(j)) > map.get(b.charAt(j))){
                    return false;
                }else if ( map.get(a.charAt(j)) == map.get(b.charAt(j)) ){
                    continue;
                }else {
                    break;
                }
            }
            // 一个结束了，eg : app 与 apple的比较情况
            // app 在 apple之前。
            if (j == Math.min(a.length(),b.length())){
                if (a.length()>b.length()){
                    return false;
                }
            }

        }
        return true;



    }

    public static void main(String[] args) {
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        String[] words = {"hello","leetcode"};
        System.out.println(isAlienSorted(words,order));

    }


}
