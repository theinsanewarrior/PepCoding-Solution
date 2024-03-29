import java.util.*;
public class recoverBST {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static void recoverTree1(TreeNode curr){
        if(curr == null)
            return;
        recoverTree1(curr.left);
        if(prev!=null && prev.val > curr.val){
            if(first == null){
                first = prev;
            }
            second = curr;
        }
        prev = curr;
        recoverTree1(curr.right);
    }
    
    public static TreeNode prev;
    public static TreeNode first;
    public static TreeNode second;
    
    public static void recoverTree(TreeNode root) {
        prev = null;
        first = null;
        second = null;
        recoverTree1(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
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
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
