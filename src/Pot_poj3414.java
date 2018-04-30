//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
///**
// * @program: Leetcode
// * @description: bfs
// * @author: Wangky
// * @create: 2018-04-24 15:22
// **/
//public class Pot_poj3414 {
//    private static class Node{
//        int x,int y;
//        public Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
////    boolean
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//        Node n = new Node(a,b);
//        bfs(n);
//    }
//
//    private static void bfs(Node start,int a,int b,int c){
//        Queue<Node> queue = new LinkedList<>();
//        ((LinkedList<Node>) queue).push(start);
//        //visited
//
//        while (!queue.isEmpty()){
//            Node temp = queue.element();
//            ((LinkedList<Node>) queue).pop();
//
//            //success
//            if(temp.x == c || temp.y ==c){
//                //success,打印路径
//                return;
//            }
//
//            //6个判断:fill(1),fill(2),drop(1),drop(2),pour(1,2),pour(2,1)
//            if(){
//
//            }else if (){
//
//            }
//        }
//    }
//}
