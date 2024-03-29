import java.util.*;
public class removeNthNodeFromEndMethod1 {
    public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    int size=0;
    ListNode traverse = head;
    while(traverse!=null){
        traverse = traverse.next;
        size++;
    }
    ListNode prev = null;
    traverse = head;
    for(int i=0; i<size-n; i++){
        prev = traverse;
        traverse = traverse.next;
    }
    if(size-n == 0)
        head = head.next;
    else
        prev.next = traverse.next;
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
    int n = scn.nextInt();
    ListNode h1 = createList(n);

    int m = scn.nextInt();
    h1 = removeNthFromEnd(h1, m);
    printList(h1);
  }
}
