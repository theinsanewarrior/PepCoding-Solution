import java.util.*;
public class reverseNodeInKGroupMethod2 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static int size(ListNode head){
        ListNode curr = head;
        int ans = 0;
        while(curr!=null){
            curr = curr.next;
            ans++;
        }
        return ans;
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {
        ListNode ohead = new ListNode(-1);
        ListNode otail = ohead;
        
        ListNode curr = head;
        
        int nrsf = size(head);
        if(nrsf<k || k==0)
            return head;
        
        while(nrsf>=k){
            ListNode chead = null;
            ListNode ctail = null;
            int temp = k;
            while(temp-->0){
                ListNode next =curr.next;
                if(chead == null){
                    chead = curr;
                    ctail = curr;
                    ctail.next = null;
                }
                else{
                    curr.next = chead;
                    chead = curr;
                }
                curr = next;
            }
            if(ohead == otail){
                ohead.next = chead;
                otail = ctail;
            }
            else{
                otail.next = chead;
                otail = ctail;
            }
            nrsf-=k;
        }
        if(nrsf!=0)
            otail.next = curr;
        
        return ohead.next;
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

        int k = scn.nextInt();
        h1 = reverseInKGroup(h1, k);
        printList(h1);
    }
}
