import java.util.*;
public class MergeSortLL {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode MergeTwoSortedLists(ListNode node1, ListNode node2){
        ListNode buffer = new ListNode(-1);
        ListNode head = buffer;
        while(node1!=null && node2!=null){
            if(node1.val < node2.val){
                buffer.next = node1;
                buffer = buffer.next;
                node1 = node1.next;
            }
            else{
                buffer.next = node2;
                buffer = buffer.next;
                node2 = node2.next;
            }
        }
        if(node1!=null)
            buffer.next = node1;
        if(node2!=null)
            buffer.next = node2;
        return head.next;
    }
    
    public static ListNode mergeSort(ListNode head) {
        if(head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode node1 = mergeSort(head);
        ListNode node2 = mergeSort(head2);
        return MergeTwoSortedLists(node1, node2);
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

        ListNode head = mergeSort(h1);
        printList(head);
    }
}
