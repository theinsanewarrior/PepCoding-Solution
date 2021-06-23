import java.util.*;
public class segregateNodeOfLinkedlistOverPivotIndex {
    public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

    public static ListNode segregate(ListNode head, int pivotIdx) {
        // get pivot
        ListNode pivot = head, curr = null;
        while(pivotIdx-->0){
            curr = pivot;
            pivot = pivot.next;
        }
        if(curr!=null)
            curr.next = pivot.next;
        else
            head = head.next;
        // segregate
        ListNode sh = new ListNode(-1), gh = new ListNode(-1);
        ListNode sc = sh, gc = gh;
        curr = head;
        while(curr!=null){
            if(curr.val <= pivot.val){
                sc.next = curr;
                sc = sc.next;
            }
            else{
                gc.next = curr;
                gc = gc.next;
            }
            curr = curr.next;
        }
        sc.next = pivot;
        pivot.next = gh.next;
        gc.next = null;
        return sh.next;
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
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}
