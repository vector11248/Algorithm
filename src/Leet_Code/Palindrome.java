package Leet_Code;

import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-08-16 08:40
 **/
public class Palindrome {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }


    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverseList(slow.next);
        ListNode cur = head;
        while (rev != null && cur != slow.next){
            if(rev.val != cur.val) return false;
            rev = rev.next ;
            cur = cur.next;
        }

        return true;
    }



    public static ListNode reverseList(ListNode head){

        if (head == null) return null;

        // init
        ListNode now = head.next;
        head.next = null;
        //一定要注意处理边界条件
        while (now != null){
            ListNode temp = now.next;
            now.next = head;
            head = now;
            now = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        System.out.println(reverseList(head).val);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(1);
//        ListNode cur = head;
//        while (cur!=null){
//            System.out.print(cur.val+"  --->  ");
//            cur=cur.next;
//        }
//        System.out.println("----------reverse-----------");
//        ListNode reverse = reverseList(head);
//
//        while (reverse!=null){
//            System.out.println(reverse.val+"--->");
//            reverse = reverse.next;
//        }

        System.out.println(isPalindrome(head));


    }
}
