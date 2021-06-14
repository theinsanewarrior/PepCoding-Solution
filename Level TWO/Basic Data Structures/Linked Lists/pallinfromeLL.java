import java.util.*;
public class pallinfromeLL {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        // finding mid
        ListNode one = head, two = head;
        while(two.next!=null && two.next.next != null){
            one = one.next;
            two = two.next.next;
        }
        ListNode mid = one;
        
        // reversing second half
        two = one.next;
        ListNode prev = null;
        while(two!=null){
            ListNode temp = two.next;
            two.next = prev;
            prev = two;
            two = temp;
        }
        
        // checking pallindrome
        two = prev;
        one = head;
        boolean ans = true;
        while(two!=null){
            if(two.val != one.val)
                ans = false;
            two = two.next;
            one = one.next;
        }
        
        // re-reversing second half
        two = prev;
        prev = null;
        while(two!=null){
            ListNode temp = two.next;
            two.next = prev;
            prev = two;
            two = temp;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        System.out.println(isPalindrome(dummy.next));
    }
}
