package Leet_Code;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-08-17 07:56
 **/
public class PartitionLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    public static ListNode partionFunc(ListNode head,int num){
        ListNode lessHead=null;
        ListNode equalHead=null;
        ListNode moreHead=null;

        ListNode lessList = null;
        ListNode equalList = null;
        ListNode moreList = null;

        ListNode cur = head;

        while (cur!=null){
            if(cur.val<num){
                if(lessList==null){
//                    lessList = cur;
                    lessList = new ListNode(cur.val);
                    lessHead = lessList;
                }else {
//                    lessList.next = cur;
                    lessList.next = new ListNode(cur.val);
                    lessList = lessList.next;
                }
            }else if(cur.val == num){
                if(equalList == null){
//                    equalList = cur;
                    equalList = new ListNode(cur.val);
                    equalHead = equalList;
                }else {
//                    equalList.next = cur;
                    equalList.next = new ListNode(cur.val);
                    equalList = equalList.next;
                }
            }else {
                if(moreList == null){
//                    moreList = cur;
                    moreList = new ListNode(cur.val);
                    moreHead = moreList;
                }else {
//                    moreList.next = cur;
                    moreList.next = new ListNode(cur.val);
                    moreList = moreList.next;
                }
            }
            cur = cur.next;
        }

//        if(lessHead==null && equalHead==null && moreHead == null) return null;
//        else if(lessHead == null && equalHead == null && moreHead != null) return moreHead;
//        else if(lessHead == null && equalHead!=null && moreHead ==null) return equalHead;
//        else if(lessHead == null && equalHead!=null && moreHead !=null){
//            equalList.next = moreHead;
//            return equalHead;
//        }
//        else if(lessHead!=null){
//            if(equalHead != null && moreHead !=null){
//                lessList.next = equalHead;
//                equalList.next = moreHead;
//            }else if(equalHead ==null && moreHead !=null){
//                lessList.next = moreHead;
//            }else if(equalHead!=null && moreHead == null){
//                lessList.next = equalHead;
//            }
//        }
//        return lessHead;

        if(lessList==null && equalList==null && moreList == null) return null;
        else if(lessHead == null && equalHead == null && moreHead != null) return moreHead;
        else if(lessHead == null && equalHead!=null && moreHead ==null) return equalHead;
        else if(lessHead == null && equalHead!=null && moreHead !=null){
            equalList.next = moreHead;
            return equalHead;
        }
        else if(lessHead!=null){
            if(equalHead != null && moreHead !=null){
                lessList.next = equalHead;
                equalList.next = moreHead;
            }else if(equalHead ==null && moreHead !=null){
                lessList.next = moreHead;
            }else if(equalHead!=null && moreHead == null){
                lessList.next = equalHead;
            }
        }
        return lessHead;

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

        ListNode cur = head;
        while (cur!=null){
            System.out.print(cur.val+"    ");
            cur = cur.next;
        }

        //ExpedOutput:
        // 1-2-3-null
        // 5-5-null
        // 8-7-6-9-null

        // 1-2-3-5-5-8-7-6-9

        System.out.println("--------Partition -------------");
        ListNode par = partionFunc(head,5);
        System.out.println(par);
//        System.out.println(par.val);
        ListNode cur1 = par;
        while (cur1 != null){
            System.out.print(cur1.val + "    ");
            cur1 = cur1.next;
        }
    }




}
