package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-12-25 12:54
 **/
public class No_96_Unique_Binary_Search_Trees {

    public static int numTrees(int n) {

//        if (n==1) return 1;
//        if (n==2) return 2;
//        int cnt = 0;
//        for (int i=1;i<n-1;i++){
//            cnt += numTrees(i) * numTrees(n-1-i);
//        }
//        cnt += numTrees(numTrees(n-1))*2;
//        return cnt;

        // 以上代码会溢出的
        if (n==1) return 1;
        if (n==2) return 2;
        else {
            int[] unique = new int[n + 5];
            unique[0] = 1;
            unique[1] = 1;
            unique[2] = 2;
           for (int i = 3;i<=n;i++){
               for (int j = 0;j<i;j++){
                   unique[i] += unique[j] * unique[i-1-j];
               }
           }
           return unique[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }
}
