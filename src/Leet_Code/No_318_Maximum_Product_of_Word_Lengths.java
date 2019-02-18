package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-02-18 08:59
 **/
public class No_318_Maximum_Product_of_Word_Lengths {

    public int maxProduct(String[] words) {
        int[] bits = new int[words.length];
        for (int i=0;i<words.length;i++){
            for (char c:words[i].toCharArray()){
                bits[i] |= (1 << (c-'a'));
            }
        }
        int max = 0;
        for (int i=0;i<words.length;i++){
            for (int j=i+1;j<words.length;j++){
                if ((bits[i] & bits[j]) == 0){
                    max = Math.max(words[i].length()*words[j].length(),max);
                }
            }
        }
        return max;
    }

}
