import java.util.*;
public class removeDuplicatesFromSortedLL {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    // public static ListNode thead;
    // public static ListNode ttail;
    public static ListNode removeDuplicates(ListNode head) {
        if(head == null || head.next==null)
            return head;
        ListNode ch = new ListNode(Integer.MAX_VALUE);
        ListNode ct = ch;
        ListNode curr = head;
        while(curr!=null){
            if(curr.val != ct.val){
                ct.next = curr;
                ct = ct.next;
            }
            curr = curr.next;
        }
        ct.next = null;
        return ch.next;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }
}
