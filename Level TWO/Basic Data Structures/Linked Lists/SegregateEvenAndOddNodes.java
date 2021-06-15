import java.util.*;
public class SegregateEvenAndOddNodes {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);
        ListNode ehead = even, ohead = odd;
        while(head!=null){
            if(head.val%2==0){
                even.next = head;
                head = head.next;
                even = even.next;
                even.next = null;
            }
            else{
                odd.next = head;
                head = head.next;
                odd = odd.next;
                odd.next = null;
            }
        }
        even.next = ohead.next;
        return ehead.next;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }
        
        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
