package Leet_Code;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-09-06 10:53
 **/
public class WordDict2 {
    public static void main(String[] args) {

    }
    /*public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict =  new HashSet<>(wordDict);

    }*/

    List<String> DFS(String s, Set<String> dict, HashMap<String,LinkedList<String>> map){
        if (map.containsKey(s)){
            return map.get(s);
        }
        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0){
            res.add("");
            return res;
        }
        for (String word:dict){
            if (s.startsWith(word)){
                List<String> sublist = DFS(s.substring(word.length()),dict,map);
                for (String sub : sublist){
                    res.add(word + (sub.isEmpty()?"":" ")+sub);
                }
            }
        }
        map.put(s,res);
        return res;
    }




}
