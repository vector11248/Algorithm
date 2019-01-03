package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-29 12:31
 **/
public class No_744_Find_Smallest_Letter_Greater_Than_Target {

    public char nextGreatestLetter1(char[] letters, char target) {

        int lo = 0;
        int hi = letters.length-1;
        while (lo!=hi){
            if (target >= letters[lo] && target < letters[lo+1]){
                return letters[lo+1];
            }
        }
        return letters[0];

    }
    public char nextGreatestLetter(char[] letters, char target){

        int lo = 0;
        int hi = letters.length;
        while (lo<hi){
            int mid = lo + (hi-lo)/2;
            if (target >= letters[mid]){
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        return letters[lo%letters.length];
    }

}
