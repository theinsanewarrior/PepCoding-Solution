import java.util.*;
public class sortedDLLtoBST {
    public static Scanner scn = new Scanner(System.in);

  public static class Node {
    int val = 0;
    Node left = null;
    Node right = null;

    Node(int val) {
      this.val = val;
    }
  }

  // left : prev, right : next
    public static Node SortedDLLToBST(Node head) {
        if(head == null || head.right==null)
            return head;
        // get mid
        Node slow = head;
        Node fast = head;
        while(fast.right!=null && fast.right.right!=null){
            slow = slow.right;
            fast = fast.right.right;
        }
        Node mid = slow;
        
        // left
        if(mid.left!=null){
            mid.left.right = null;
            mid.left = null;
            mid.left = SortedDLLToBST(head);
        }
        
        // right
        mid.right.left = null;
        Node rightN = mid.right;
        mid.right = null;
        mid.right = SortedDLLToBST(rightN);
        
        return mid;
    }

  // Input_code===================================================

  public static void display(Node node) {
    if (node == null)
      return;

    StringBuilder sb = new StringBuilder();
    sb.append((node.left != null ? node.left.val : "."));
    sb.append(" -> " + node.val + " <- ");
    sb.append((node.right != null ? node.right.val : "."));

    System.out.println(sb.toString());

    display(node.left);
    display(node.right);

  }

  public static Node makeList(int n) {
    Node dummy = new Node(-1);
    Node prev = dummy;
    while (n-- > 0) {
      Node node = new Node(scn.nextInt());
      prev.right = node;
      node.left = prev;
      prev = prev.right;
    }

    Node head = dummy.right;
    head.left = dummy.right = null;

    return head;
  }

  public static void main(String[] args) {
    Node head = makeList(scn.nextInt());

    head = SortedDLLToBST(head);
    display(head);
  }
}
