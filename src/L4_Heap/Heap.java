package L4_Heap;

import java.util.Random;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-05-21 20:34
 **/
public class Heap {

    private static int heap_size ;

    // return index of A[i]
    public static int parent(int[] A,int i){
        if(i == 1) return -1; // node 1's parent is -1 ?TODO
        return i/2;
    }

    // return index of A[i]'s left child
    public static int left(int[] A,int i){
        if( 2*i <= A.length ) return 2*i; // not A.length,it's heap-size(A)
        else return -1; //-1 represent null
    }

    public static int right(int[] A,int i){
        if(2*i+1 <= A.length) return 2*i+1;
        else return -1;
    }

    public static int heap_size(int[] A){
        return heap_size;
    }

    public static void setHeap_size(int val){
        heap_size = val;
    }




    public static void Max_Heapify(int[] A,int i){
        // correct a single violation of the heap property in a subtree at its root

        //A:an array where the left and right children of i root heaps,but i may not
        //Output:A modified so that i roots a heap
        //Running time: : O(log n) where n = heap-size[A] − i
        int l = left(A,i);
        int r = right(A,i);
        int largest;
        if(l>0 && l<=heap_size(A) && A[i]<A[l]){ //the root less than its left children node
            largest = l;
        }else largest = i;
        if(r>0 && r<=heap_size(A) && A[r]>A[largest]){
            largest = r;
        }
        if(largest != i){
            Util util = new Util();
            util.swap(A,i,largest);
            Max_Heapify(A,largest);
        }
    }

    public static void Build_Max_Heap(int[] A){
        //input:an unsorted array
        //output:A modified to represent a heap
        //Running time:O(n)  where n = length[A]

//        heap_size = A.length;
        for(int i=heap_size(A)/2;i>=1;i--){
            Max_Heapify(A,i);
        }

    }

    public static void Heap_Sort(int[] A){
        //input:an unsorted array
        //output:A modified to be sorted from smallest to largest
        //Running time:O(nlgn) n = length(A)
        Build_Max_Heap(A);
        for(int i=A.length-1;i>=2;i--){
            Util util = new Util();
            util.swap(A,1,i);
            setHeap_size(heap_size-1);
            Max_Heapify(A,1);

        }

    }


    public static void main(String[] args) {
        int[] A = new int[10];
        Random random = new Random(20);
        for(int i=1;i<= 5;i++){
            A[i] = random.nextInt(100);
            System.out.print(A[i]+" ");
        }
        System.out.println();
        heap_size = A.length-1;
//        Build_Max_Heap(A);
        Heap_Sort(A);
        for (int i=1;i<A.length;i++){
            System.out.print(A[i]+"  ");
        }
    }

}
