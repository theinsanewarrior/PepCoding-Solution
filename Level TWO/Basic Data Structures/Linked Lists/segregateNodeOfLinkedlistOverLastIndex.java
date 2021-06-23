import java.util.*;
public class segregateNodeOfLinkedlistOverLastIndex {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateOnLastIndex(ListNode head) {
        ListNode sh = new ListNode(-1), gh = new ListNode(-1);
        ListNode sc = sh, gc = gh, curr = head;
        // get pivot data
        int data = 0;
        while(curr.next!=null){
            curr = curr.next;
        }
        data = curr.val;
        
        curr = head;
        while(curr!=null){
            if(curr.val <= data){
                sc.next = curr;
                sc = sc.next;
            }
            else{
                gc.next = curr;
                gc = gc.next;
            }
            curr = curr.next;
        }
        gc.next = null;
        sc.next = gh.next;
        return sc;
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
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    }
}
