import java.util.*;
public class removeAllDuplicatesFromSortedLL{
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode itr = new ListNode(-1);
        ListNode th = itr;
        itr.next = head;
        ListNode curr = head.next;
        while(curr!=null){
            boolean flag = false;
            while(curr != null && itr.next.val == curr.val){
                flag = true;
                curr = curr.next;
            }
            
            if(flag == true){
                itr.next = curr;
                if(curr!=null)
                    curr = curr.next;
            }
            else{
                itr = itr.next;
                if(curr!=null)
                    curr = curr.next;
            }
        }
        return th.next;
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