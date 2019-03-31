import java.util.ArrayList;
import java.util.List;

public class 链表中点 {

    public ListNode middleNode_On(ListNode head) {

        List<ListNode> nums = new ArrayList<>();

        while(head!=null){
            nums.add(head);
            head = head.next;
        }

        int mid = nums.size() % 2 == 0 ? nums.size()/2 +1 : nums.size()/2;
        return nums.get(mid);
    }


    public ListNode middleNode(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next != null){
            fast = head.next;
            slow = head.next.next;
        }

        return slow;
    }

    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }
}
