package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-03-07 13:44
 **/
public class QuickSort {

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static int partition(int[] a,int p, int r){
        // 返回partition所在的下标，该下标之前的元素小于等于，之后的大于等于
        int i = p;
        int j = r+1;
        int x = a[p];
        while(true){
            while ( a[++i] < x && i<r); // 遇到等于号交换
            while ( a[--j] > x);
            if (i>=j) break;
            swap(a,i,j);
        }
        // 最终碰到一起，或者 j 在 i前边
        a[p] = a[j];
        a[j] = x;
        return j;
    }

    public static void quickSort(int[] a, int p , int r){
        if (p<r){
            int q = partition(a,p,r);
            quickSort(a,p,q-1);
            quickSort(a,q+1,r);
        }
    }

    public static void printArray(int[] nums){
        for(int n:nums){
            System.out.print(n + "  ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] test = {7,9,0,3,5};
        int[] test1 = {1,2,3,4,5};
        int[] test2 = {2,2,2,2,2};
        int[] test3 = {5,4,3,2,1};

        quickSort(test,0,test.length-1);
        quickSort(test1,0,test1.length-1);
        quickSort(test2,0,test2.length-1);
        quickSort(test3,0,test3.length-1);

        printArray(test);
        printArray(test1);
        printArray(test2);
        printArray(test3);

    }


}
