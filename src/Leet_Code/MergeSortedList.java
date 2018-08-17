package Leet_Code;

import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-08-15 08:32
 **/



public class MergeSortedList {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){

        ListNode resList = null;
        ListNode head = null;

        while (l1!= null && l2!=null){
            int n;
            if(l1.val<=l2.val){
                n = l1.val;
                l1=l1.next;
            }else {
                n = l2.val;
                l2 = l2.next;
            }
            if(resList == null){
                resList = new ListNode(n);
                head = resList;
            }else {
                resList.next = new ListNode(n);
                resList = resList.next;
            }

        }

        if (resList != null){
            if(l1==null && l2 != null){
                resList.next = l2;
            }else if(l1 != null && l2 == null){
                resList.next = l1;
            }
        }else {
            if(l1==null) return l2;
            if (l2 == null) return l1;
        }


        return head;

    }




    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = mergeTwoLists(l1,l2);

        while (res!=null){
            System.out.println(res.val + "   ");
            res = res.next;
        }

    }

}
