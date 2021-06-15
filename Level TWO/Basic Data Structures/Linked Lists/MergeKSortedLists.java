import java.util.*;
public class MergeKSortedLists {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return mergeKListsHelp(lists, 0, lists.length-1);
    }
    
    public static ListNode mergeKListsHelp(ListNode[] lists, int s, int e){
        if(s == e)
            return lists[s];
        int mid = (s+e)/2;
        ListNode node1 = mergeKListsHelp(lists, s, mid);
        ListNode node2 = mergeKListsHelp(lists, mid+1, e);
        
        return mergeTwoLists(node1, node2);
    }
    
    public static ListNode mergeTwoLists(ListNode node1, ListNode node2){
        ListNode buffer =  new ListNode(-1);
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
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists(list);
        printList(head);
    }
}
