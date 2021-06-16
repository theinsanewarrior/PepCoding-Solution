import java.util.*;
public class copyLLWithRandomPointer {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        HashMap<ListNode, ListNode> hm = new HashMap<>();
        ListNode curr = head;
        ListNode head1 = new ListNode(-1);
        ListNode curr1 = head1;
        while(curr!=null){
            curr1.next = new ListNode(curr.val);
            hm.put(curr, curr1.next);
            curr1 = curr1.next;
            curr = curr.next;
        }
        curr = head;
        curr1 = head1.next;
        while(curr!=null){
            curr1.random = hm.get(curr.random);
            curr = curr.next;
            curr1 = curr1.next;
        }
        return head1.next;
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
