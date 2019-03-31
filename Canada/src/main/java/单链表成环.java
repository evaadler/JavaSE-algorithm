import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 单链表成环 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = a;

        int flag = circleLength_classic(a);
        System.out.println(flag);

        int len = circleIntersection(a);
        System.out.println(len);
    }

    public static boolean isCircle_set(ListNode head){
        Set<ListNode> set = new HashSet<>();

        ListNode p = head;

        while (p != null){

            //if this set did not already contain the specified, return true;
            if (!set.add(p)){
                return true;
            }

            p = p.next;
        }

        return false;
    }


    public boolean isCircle_classic(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while( fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                return true;
            }
        }

        return false;
    }

    public static int circleLength(ListNode head){
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        int length = 1;

        while (slow != fast){


            slow = slow.next;
            fast = fast.next.next;

            length++;
        }
        return length;
    }


    public static int circleLength_classic(ListNode head){
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }

        int length = 1;

        slow = slow.next;
        fast = fast.next.next;

        while (slow != fast){


            slow = slow.next;
            fast = fast.next.next;

            length++;
        }
        return length;
    }

    public static int circleIntersection(ListNode head){

        HashMap<ListNode, Integer> map = new HashMap<>();

        ListNode p = head;

        int num=0;
        Integer val;
        while(head != null){
            val = map.put(head, ++num);

            if (val!=null){
                return val;
            }

            head = head.next;
        }
        return num;
    }
/*
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }*/
}


