import java.util.*;
public class reverseInRange {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseInRange(ListNode head, int n, int m) {
        ListNode curr = head;
        ListNode prev = null, ch = null, ct = null;
        int idx = 1;
        while(curr!=null){
            if(idx<n){
                prev = curr;
                curr = curr.next;
            }
            else if(idx>=n && idx <=m){
                ListNode temp = curr.next;
                if(ch == null){
                    curr.next = null;
                    ch = curr;
                    ct = curr;
                }
                else{
                    curr.next = ch;
                    ch = curr;
                }
                curr = temp;
            }
            else{
                if(prev!=null){
                    prev.next = ch;
                    ct.next = curr;
                }
                else{
                    head = ch;
                    ct.next = curr;
                }
                break;
            }
            idx++;
        }
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
        int sz = scn.nextInt();
        ListNode h1 = createList(sz);

        int m = scn.nextInt();
        int n = scn.nextInt();

        h1 = reverseInRange(h1, m, n);
        printList(h1);
    }
}
