package L4_Heap;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-05-21 21:09
 **/
public class Util {
    public void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
