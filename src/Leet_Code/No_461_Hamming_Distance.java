package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-02-19 10:32
 **/
public class No_461_Hamming_Distance {

    public int hammingDistance(int x, int y) {
        int dist = 0;
        int val = x^y;
        while (val!=0){
            dist++;
            val &= val-1;
        }
        return dist;
    }
}
