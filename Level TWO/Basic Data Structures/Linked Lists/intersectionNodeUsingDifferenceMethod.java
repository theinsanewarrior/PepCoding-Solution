import java.util.*;
public class intersectionNodeUsingDifferenceMethod {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        int sizeA=0, sizeB=0;
        while(currA!=null){
            sizeA++;
            currA = currA.next;
        }
        while(currB!=null){
            sizeB++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        if(sizeA > sizeB){
            for(int i=0; i<sizeA-sizeB; i++){
                currA = currA.next;
            }
        }
        else if(sizeA < sizeB){
            for(int i=0; i<sizeB-sizeA; i++){
                currB = currB.next;
            }
        }
        
        while(currA!=null && currB!=null){
            if(currA == currB)
                return currA;
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }

    // Input_code===================================================

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
        ListNode head1 = makeList(scn.nextInt());

        int idx = scn.nextInt();

        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}
