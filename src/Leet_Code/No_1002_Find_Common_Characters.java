package Leet_Code;

import java.util.HashMap;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-03-07 20:05
 **/
public class No_1002_Find_Common_Characters {


    public static List<String> commonChars(String[] A) {
        if(A == null || A.length == 0){
            return null;
        }
        int n = A[0].length();
        HashMap<Character,Integer> hashmap = new HashMap<>();
        for(int i=0;i<n;i++){
            if( !hashmap.containsKey(A[0].charAt(i)) ){
                hashmap.put(A[0].charAt(i),1);
            }else{
                hashmap.replace(A[0].charAt(i),hashmap.get(A[0].charAt(i)) + 1);
            }
        }
        for(int i=1;i<A.length;i++){
            for(int j = 0;j<A[i].length();j++){
                if( !hashmap.containsKey(A[i].charAt(j)) ){
                    continue;
                }
                // 如果A[0] 中仅仅出现过一次的字母，那么在公共出现的次数也是最多为1
                if( hashmap.get(A[i].charAt(j)) == 1 ){
                    continue;
                }



                if( hashmap.get(A[i].charAt(j)) > 1){
                    int temp = 0;
                    for(int k = 0;k<A[i].length();k++){
                        if(A[i].charAt(k) == A[i].charAt(j) ){
                            temp ++;
                        }
                    }
                    if(temp < hashmap.get(A[i].charAt(j))){
                        hashmap.replace(A[i].charAt(j),temp);
                    }
                }
            }
        }

        System.out.println(hashmap);

        return null;

    }

    public static void main(String[] args) {
        String[] A = {"bella","label","roller"};
        commonChars(A);
    }

}
