import java.util.*;
public class FoldLinkedList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode reverse(ListNode node){
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
    
    public static ListNode midNode(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void fold(ListNode head) {
        ListNode mid = midNode(head);
        // System.out.println(mid.val);
        ListNode st2 = reverse(mid.next);
        mid.next = null;
        ListNode st1 = head;
        while(st2!=null){
            ListNode nxt1 = st1.next;
            ListNode nxt2 = st2.next;
            
            st1.next = st2;
            st2.next = nxt1;
            
            st1 = nxt1;
            st2 = nxt2;
        }
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
        fold(head);
        printList(head);
    }
}
