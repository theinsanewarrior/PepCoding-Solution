import java.util.*;
public class bstToSortedDoublyLLMorris {
    public static Scanner scn = new Scanner(System.in);

  public static class Node {
    int val = 0;
    Node left = null;
    Node right = null;

    Node(int val) {
      this.val = val;
    }
  }
  
    public static Node rightMostNode(Node ln, Node curr){
        Node rmn = ln;
        while(rmn.right !=null && rmn.right !=curr){
            rmn = rmn.right;
        }
        return rmn;
    }

    public static Node bToDLL(Node root) {
        Node curr = root, prev = new Node(-1);
        Node head = prev;
        while(curr!=null){
            if(curr.left==null){
                curr.left = prev;
                if(prev!=null)
                    prev.right = curr;
                
                prev = curr;
                curr = curr.right;
            }
            else{
                Node rmn = rightMostNode(curr.left, curr);
                if(rmn.right == null){
                    rmn.right = curr;
                    curr = curr.left;
                }
                else{
                    rmn.right = null;
                    curr.left = prev;
                    if(prev!=null)
                        prev.right = curr;
                    
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        Node ans = head.right;
        ans.left = null;
        return ans;
    }

  // input_section=================================================

  public static void display(Node node) {
    Node head = node;
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.right;
      if (node == head)
        break;
    }

  }

  public static Node constructFromInOrder_(int[] in, int si, int ei) {
    if (si > ei)
      return null;

    int mid = (si + ei) / 2;
    Node node = new Node(in[mid]);

    node.left = constructFromInOrder_(in, si, mid - 1);
    node.right = constructFromInOrder_(in, mid + 1, ei);

    return node;
  }

  public static Node constructFromInOrder(int[] inOrder) {
    int n = inOrder.length;
    return constructFromInOrder_(inOrder, 0, n - 1);
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] in = new int[n];
    for (int i = 0; i < n; i++)
      in[i] = scn.nextInt();

    Node root = constructFromInOrder(in);
    root = bToDLL(root);
    display(root);
  }

  public static void main(String[] args) {
    solve();
  }
}
