package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-09-19 19:27
 **/
public class Num148_SortList {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    public static ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while ( l1 !=null && l2 !=null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1!=null) cur.next = l1;
        if(l2 != null) cur.next = l2;
        return dummy.next;
    }



    public static ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode middle = getMiddle(head);
        ListNode middle_next = middle.next;
        middle.next = null;
        ListNode sl1 = sortList(head);
        ListNode sl2 = sortList(middle_next);
        return merge(sl1,sl2);

    }

    public static void main(String[] args) {


        ListNode head = new ListNode(1);
        head.next = new ListNode(8);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode cur = sortList(head);
        while (cur!=null){
            System.out.print(cur.val+"    ");
            cur = cur.next;
        }

    }

    private static ListNode getMiddle(ListNode head){
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
