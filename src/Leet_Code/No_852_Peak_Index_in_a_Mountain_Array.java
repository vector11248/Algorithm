package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-27 19:01
 **/
public class No_852_Peak_Index_in_a_Mountain_Array {

//    public static int peakFinder(int[] A,int start,int end){
//        int mid = (start + end) / 2;
//        if (A[mid] < A[mid-1]){
//          return   peakFinder(A,start,mid-1);
//        }else if (A[mid] < A[mid+1]){
//          return   peakFinder(A,mid+1,end);
//        }else {
//            return mid;
//        }
//    }
//
//    public int peakIndexInMountainArray(int[] A) {
//        return peakFinder(A,0,A.length-1);
//    }

    //递归还是太慢了
    public static int peakIndexInMountainArray(int[] A) {

        // 在本题当中，规定了peak不在两头，所以不会出现 mid-1,mid+1越界的情况。
        int lo = 0;
        int hi = A.length-1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            if (A[mid] < A[mid-1]){
                hi = mid-1;
            }else if(A[mid] < A[mid+1]){
                lo = mid+1;
            }else {
                return mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] A = {11,7,9};
        System.out.println(peakIndexInMountainArray(A));
    }

}
