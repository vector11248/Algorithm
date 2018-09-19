package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-09-16 11:37
 **/
public class Num147_InsertionSortList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head!=null && head.next !=null){
            if(head.val <= head.next.val){
                head = head.next;
            }
            else {
                ListNode cur = dummy;
                while (cur.next.val < head.next.val){
                    cur = cur.next;
                }
                ListNode temp_head_next = head.next;
                ListNode temp_cur_next = cur.next;
                cur.next = head.next;
                head.next = head.next.next;
                temp_head_next.next = temp_cur_next;

            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(8);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(7);


        ListNode cur = insertionSortList(head);
        while (cur!=null){
            System.out.print(cur.val+"    ");
            cur = cur.next;
        }
    }


}
