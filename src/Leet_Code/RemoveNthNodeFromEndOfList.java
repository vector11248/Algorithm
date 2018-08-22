package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-08-21 09:42
 **/
public class RemoveNthNodeFromEndOfList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n==1) return null;
        ListNode cur = head;
        ListNode pre = head;
        while (n!=0){
            pre = pre.next;
            if(pre == null){
                return head.next;
            }
            n--;
        }
        while (pre.next!=null && cur.next!= null){
            pre = pre.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(8);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(7);
//        head.next.next.next.next = new ListNode(5);


        ListNode cur = removeNthFromEnd(head,2);
        while (cur!=null){
            System.out.print(cur.val+"    ");
            cur = cur.next;
        }

    }

}
