import java.util.Scanner;
class Tree{
    Tree left;
    Tree right;
    char root;
}


public class BSTPostOrder {

    private  static String preOrder;
    private  static  String inOrder;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        preOrder = "gdafemhz";
        inOrder =  "adefghmz";
        PrintPostOrder(0,preOrder.length()-1,0,inOrder.length()-1,preOrder.length());

    }
    // 1:Pre
    // 2:In
    //length:子树的长度
    private static void PrintPostOrder(int start1 ,int end1 , int start2,int end2,  int length){
        if(length == 0) return;
        if(length == 1){
            System.out.println(inOrder.charAt(start2));
            return;
        }

        int i=0;
        while (preOrder.charAt(start1) != inOrder.charAt(start2 +i)) i++;

        PrintPostOrder(start1+1,start1+i,start2,start2+i-1,i);
        PrintPostOrder(start1+i+1,end1,start2+i+1,end2,end2-start2-i);
        System.out.println(inOrder.charAt(start2+i));


    }


}
