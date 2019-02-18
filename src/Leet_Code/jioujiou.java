package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-25 13:06
 **/
public class jioujiou {

    public static void findTwoJi(int[] arr){

        int length = arr.length;
        if ( arr == null || length==0) {
            return;
        }
        int e = 0;
        for (int i = 0;i<length;i++){
            e ^= arr[i];
        }
        int k = 0; // 第k位是1，从0开始找。
        while (true){
            if( ((e>>k)&1)==1 ){
                break;
            }
            k++;
        }
        int e1 = 0;
        for (int i=0;i<length;i++){
            if(((arr[i]>>k)&1)==1){
                e1 ^= arr[i];
            }
        }
        System.out.println(k);
        System.out.println("a is : "+e1);
        System.out.println("b is : "+(e1^e));

    }


    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,2,3,9,9,4,5,4};
        int[] arr1 = {1,1,0,0,2,2,3,9,9,4,7,4};
        findTwoJi(arr);
        findTwoJi(arr1);
    }

}
