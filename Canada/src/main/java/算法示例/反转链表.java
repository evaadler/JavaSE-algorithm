package 算法示例;

public class 反转链表 {

    public ListNode reverseList(ListNode self, ListNode head){
        ListNode cur = head;
        ListNode prev = null;

        while (cur!=null){
            cur.next = prev;
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }


    class ListNode{
        int value;
        ListNode next;


        public ListNode(int val){
            this.value = val;
        }
    }

}
