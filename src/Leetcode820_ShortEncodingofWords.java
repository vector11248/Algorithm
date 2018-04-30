import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-04-30 19:16
 *
 * 给定一个单词表，对其"压缩"到一个S和一个索引的数组。从索引数组中的下标开始读取，读到#结束。问#的最短是多少？
 * 只需要判断一个单词不是其他单词后缀的情况，将其后缀累加，再加上#的个数
 * 先按长度排序，判断时用String.subString(startIndex)即可
 * startIndex=strJ.len-strI.len
 *
 *
 **/
public class Leetcode820_ShortEncodingofWords {
    public static void main(String[] args) {
        String[] words={"abc","bc","abcdf"};
        List<String> wordList = Arrays.asList(words);
        wordList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        for (String s:wordList){
            System.out.println(s);
        }
        int len = 0;
        boolean[] vis=new boolean[1005];
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i+1; j <wordList.size() ; j++) {
                //判断wordList(i)是否是其他元素的后缀
                if(wordList.get(j).substring(wordList.get(j).length()-wordList.get(i).length()).equals(wordList.get(i))){
                    vis[i]=true;//该String是其他的后缀。
                    break;
                }
            }
            if (!vis[i]){
                len = len+wordList.get(i).length()+1;
            }
        }
        System.out.println(len);

    }
}
