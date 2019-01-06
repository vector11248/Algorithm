package PointToOffer;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-06 14:49
 **/
public class No_36_InversePairs {

    public static int inversePairs(int[] data,int start,int end){
        int n = data.length;
        if (n==0) return 0;

        // 创建并声明copy数组
        int[] copy = new int[n];
        for (int i = 0;i<n;i++){
            copy[i] = data[i];
        }

        int count = inversePairsCore(data,copy,0,n-1);
        return count;


    }

    public static int inversePairsCore(int[] data,int[] copy, int start,int end){
        if (start==end){
            copy[start] = data[start];
            return 0;
        }
        int mid = start + (end-start)/2;
        int left = inversePairsCore(copy,data,start,mid);//!!!!!注意此时copy与data互换了顺序。
        int right = inversePairsCore(copy,data,mid+1,end);
        int cnt = 0;
        int i = mid; // left末尾
        int j = end; // right末尾
        int copyIndex = end;

        while (i>=start && j>=mid+1){
            if (data[i] > data[j]){
                // 存在逆序对
                copy[copyIndex--] = data[i--];
                cnt += j-mid;
            }else {
                copy[copyIndex--] = data[j--];
            }
        }

        for (;i>=start;i--){
            copy[copyIndex--] = data[i--];
        }

        for (;j>=mid+1;j--){
            copy[copyIndex--] = data[j--];
        }
//        System.out.println(right);
//        System.out.println(left);
//        System.out.println(cnt);
        return left+right+cnt;
    }

    public static void main(String[] args) {
        int[] test1 = {7,5,6,4};
        int[] test2 = {8,7,9,2,3,6};
        int[] test3 = {1,2,3,4};
        int[] test4 = {1,2,1};
        int[] test5 = {4,3,2,2,1};
        System.out.println("----final res:  ---"+inversePairs(test1,0,test1.length-1));
        System.out.println("----final res:  ---"+inversePairs(test2,0,test2.length-1));
        System.out.println("----final res:  ---"+inversePairs(test3,0,test3.length-1));
        System.out.println("----final res:  ---"+inversePairs(test4,0,test4.length-1));
        System.out.println("----final res:  ---"+inversePairs(test5,0,test5.length-1));
    }

}
