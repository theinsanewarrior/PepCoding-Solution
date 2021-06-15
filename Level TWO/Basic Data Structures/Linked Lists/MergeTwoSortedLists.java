import java.util.*;
public class MergeTwoSortedLists {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode pointer = null;
        ListNode head = null;
        if(l1.val < l2.val){
            head = l1;
            pointer = l1;
            l1 = l1.next;
        }
        else{
            head = l2;
            pointer = l2;
            l2 = l2.next;
        }
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                pointer.next = l1;
                pointer = pointer.next;
                l1 = l1.next;
            }
            else{
                pointer.next = l2;
                pointer = pointer.next;
                l2 = l2.next;
            }
        }
        if(l1!=null)
            pointer.next = l1;
        if(l2!=null)
            pointer.next = l2;
        return head;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        int m = scn.nextInt();
        ListNode h2 = createList(m);


        ListNode head = mergeTwoLists(h1, h2);
        printList(head);
    }
}
