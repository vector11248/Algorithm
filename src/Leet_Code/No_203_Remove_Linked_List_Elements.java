package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2019-01-22 12:02
 **/
public class No_203_Remove_Linked_List_Elements {


     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null){
            if (cur.val != val){
               break;
            }else {
                cur = cur.next;
            }
        }
        head = cur;
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;

    }
}
