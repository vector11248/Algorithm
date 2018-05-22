package L4_Heap;

import java.util.Random;

/**
 * @program: Leetcode
 * @description: advanced heap
 * @author: Wangky
 * @create: 2018-05-22 15:18
 **/
public class AVDHeap {
    private static int heapsize;
    private static int left(int i){
        if(2*i<=heapsize) return 2*i;
        return -1;
    }
    private static int right(int i){
        if(2*i+1<=heapsize) return 2*i+1;
        return -1;
    }
    private static int parent(int i){
        if(i==1) return -1;
        return i/2;
    }

    private static void heapify(int[] A,int i){
        // correct a single node  at index i if it break heap's property,
        // && its childen are both obey heap property
        // running time O(logn)
        int l = left(i);
        int r = right(i);
        int larger;
        if(l>0 && A[l]>A[i]){
            larger = l;
        }else larger = i;
        if(r>0){
            larger = (A[larger]>A[r])?larger:r;
        }
        if(larger!=i){
            Util util = new Util();
            util.swap(A,i,larger);
            heapify(A,larger);
        }

    }
    private static void buildMaxHeap(int[] A){
        // Running time O(n)
        for(int i = heapsize/2;i>=1;i--){
            heapify(A,i);
        }
    }

    private static void heapSort(int[] A){
        //Running time O(nlgn)

        buildMaxHeap(A);
        Util util = new Util();
        for(int i=heapsize;i>=2;i--){
            util.swap(A,i,1);
            heapsize--;
            heapify(A,1);
        }

    }


    public static void main(String[] args) {
        int[] A = new int[11];
        heapsize = A.length-1;
        Random random = new Random();
        for(int i=1;i<A.length;i++){
            A[i] = random.nextInt(20);
            System.out.print(A[i]+"  ");
        }
        System.out.println();
//        buildMaxHeap(A);
        heapSort(A);
        for (int i = 1; i < A.length; i++) {
            System.out.print(A[i]+"  ");
        }
    }

}
