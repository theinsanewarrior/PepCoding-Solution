import java.util.*;
public class UnfoldLL {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode reverse(ListNode node){
        if(node == null)
            return null;
        ListNode prev = null;
        ListNode curr = node;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void unfold(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        ListNode head2 = head.next;
        ListNode st1 = head;
        ListNode st2 = head.next;
        while(st2!=null && st2.next!=null){
            ListNode temp1 = st2;
            ListNode temp2 = st2.next;
            
            st1.next = temp2;
            st2.next = temp2.next;
            
            st1 = st1.next;
            st2 = st2.next;
        }
        head2 = reverse(head2);
        st1.next = head2;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
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
        
        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}
