import java.util.*;
public class multiplyTwoLL {
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
    
    public static ListNode singleMultiply(ListNode node, int n){
        // ListNode curr = node;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        int carry = 0;
        while(node!=null || carry!=0){
            int val = carry;
            if(node!=null){
                val+= node.val*n;
                node = node.next;
            }
            carry = val/10;
            val = val%10;
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return head.next;
    }
    
    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        // doesn't matter which one is greater
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode oh = new ListNode(-1);
        ListNode ptr = oh;
        
        ListNode c2 = l2;
        while(c2!=null){
            int val = c2.val;
            c2 = c2.next;
            ListNode sm = singleMultiply(l1, val);
            addTwoList(sm, ptr);
            ptr = ptr.next;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        return reverse(oh.next);
    }
    
    public static void addTwoList(ListNode sm, ListNode ptr){
        ListNode c1 = ptr;
        ListNode c2 = sm;
        int carry = 0;
        while(c2!=null || carry!=0){
            int sum = carry;
            if(c2!=null){
                sum = sum+c2.val;
                c2 = c2.next;
            }
            if(c1.next!=null)
                sum = sum+c1.next.val;
            else
                c1.next = new ListNode(0);
            
            c1.next.val = sum%10;
            carry = sum/10;
            c1 = c1.next;
        }
    }

    // Input_code===================================================

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

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }
}
