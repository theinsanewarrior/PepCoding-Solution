import java.util.*;
public class seggregate01BySwappingNodes {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate01(ListNode head) {
        ListNode zh = new ListNode(-1);
        ListNode zc = zh;
        ListNode oh = new ListNode(-1);
        ListNode oc = oh;
        ListNode curr = head;
        while(curr!=null){
            if(curr.val == 0){
                zc.next = curr;
                zc = zc.next;
            }
            else{
                oc.next = curr;
                oc = oc.next;
            }
            curr = curr.next;
        }
        oc.next = null;
        zc.next = oh.next;
        return zh.next;
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
        h1 = segregate01(h1);
        printList(h1);
    }
}
