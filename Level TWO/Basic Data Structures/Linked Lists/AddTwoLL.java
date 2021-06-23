import java.util.*;
public class AddTwoLL {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode reverse(ListNode node){
        ListNode curr1 = node;
        ListNode prev1 = null;
        while(curr1!=null){
            ListNode temp = curr1.next;
            curr1.next = prev1;
            prev1 = curr1;
            curr1 = temp;
        }
        return prev1;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        
        while(curr1!=null || curr2!=null ||carry!=0){
            int val = carry;
            if(curr1!=null){
                val = val+curr1.val;
                curr1 = curr1.next;
            }
            if(curr2!=null){
                val = val+curr2.val;
                curr2 = curr2.next;
            }
            carry = val/10;
            val = val%10;
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        
        head = head.next;
        head = reverse(head);
        l1 = reverse(l1);
        l2 = reverse(l1);
        return head;
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
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = addTwoNumbers(head1, head2);
        printList(ans);
    }
}
