package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-14 17:45
 **/
public class No_4_Median_of_Two_Sorted_Arrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int lo = 0;
        int hi = n1;
        while (lo <= hi){
            int partitionX = (hi+lo)/2; // partitionX 作为partition 分界 [lo,partitionX),[partitionX,hi]
//            int partitionX = (lo + hi)/2; // partitionX 作为partition 分界 [lo,partitionX),[partitionX,hi]
            int partitionY = (n1 + n2+1)/2-partitionX;

            int maxLeftX = (partitionX==0)?Integer.MIN_VALUE:nums1[partitionX-1];
            int maxLeftY = (partitionY==0)?Integer.MIN_VALUE:nums2[partitionY-1];

            int minRightX = (partitionX==n1)?Integer.MAX_VALUE:nums1[partitionX];
            int minRightY = (partitionY==n2)?Integer.MAX_VALUE:nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX){
                if ((n1+n2)%2==0){
                    return ((double)Math.max(maxLeftX,maxLeftY) + Math.min(minRightX,minRightY))/2;
                }else {
                    return (double)Math.max(maxLeftX,maxLeftY);
                }
            }else if (maxLeftX > minRightY){
                hi = partitionX-1;
            }else {
                lo = partitionX+1;
            }
        }
//        throw new IllegalArgumentException();
        return 0.0;
    }

    public static void main(String[] args) {
        int[] a = {3};
        int[] b = {-2,-1};
        System.out.println(findMedianSortedArrays(a,b));
    }

}
