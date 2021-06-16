import java.util.*;
public class copyLLWithRandomPointerMethod2 {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;
        
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        // add new node between existing nodes
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = new ListNode(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }
        // set random
        curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            if(curr.random != null)
                temp.random = curr.random.next;
            curr = curr.next.next;
        }
        // disconnect nodes
        ListNode head1 = head.next;
        ListNode prev = head1;
        curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = temp.next;
            if(prev!=head1)
                prev.next = temp;
            prev = temp;
            curr = curr.next;
        }
        return head1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}
