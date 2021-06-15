import java.util.*;
public class reverseNodeInKGroupMethod1 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if(k==0)
            return head;
        int nrsf = size(head);
        if(nrsf < k)
            return head;
        ListNode curr = head;
        
        ListNode ansH = null;
        ListNode ansT = null;
        while(k <= nrsf){
            int temp = k;
            ListNode prev = null;
            ListNode currH = curr;
            ListNode currT = null;
            while(temp-->0){
                ListNode nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
            }
            currT = currH;
            currH = prev;
            
            if(ansH == null){
                ansH = currH;
                ansT = currT;
            }
            else{
                ansT.next = currH;
                ansT = currT;
            }
            nrsf-=k;
        }
        if(nrsf>0){
            ansT.next = curr;
        }
        return ansH;
    }
    
    public static int size(ListNode head){
        int size = 0;
        ListNode curr = head;
        while(curr!=null){
            curr = curr.next;
            size++;
        }
        return size;
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
