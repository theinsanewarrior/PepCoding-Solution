import java.util.*;
public class verticalOrderSumUsingLL_DFS {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static class Node{
        int data;
        Node prev;
        Node next;
        
        Node(int data){
            this.data = data;
        }
    }
    
    public static void verticalOrderSum(Node node, TreeNode curr){
        node.data = node.data + curr.val;
        if(curr.left!=null){
            if(node.prev!=null)
                verticalOrderSum(node.prev, curr.left);
            else{
                node.prev = new Node(0);
                node.prev.next = node;
                verticalOrderSum(node.prev, curr.left);
            }
        }
        
        if(curr.right!=null){
            if(node.next!=null)
                verticalOrderSum(node.next, curr.right);
            else{
                node.next = new Node(0);
                node.next.prev = node;
                verticalOrderSum(node.next, curr.right);
            }
        }
    }
    
    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        Node head = new Node(0);
        verticalOrderSum(head, root);
        
        ArrayList<Integer> ans = new ArrayList();
        Node curr = head;
        while(curr.prev!=null){
            curr = curr.prev;
        }
        while(curr!=null){
            ans.add(curr.data);
            curr = curr.next;
        }
        return ans;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);
        
        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();
        
        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        
        ArrayList<Integer> ans = verticalOrderSum(root);
        for (Integer j : ans)
            System.out.println(j);
        
    }

    public static void main(String[] args) {
        solve();
    }
}
