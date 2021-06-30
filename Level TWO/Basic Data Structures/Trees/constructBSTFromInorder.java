import java.util.*;
public class constructBSTFromInorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static TreeNode buildTree(int s, int e, int[] inorder){
        if(s>e)
            return null;
        int mid = s + (e-s)/2;
        TreeNode curr = new TreeNode(inorder[mid]);
        curr.left = buildTree(s, mid-1, inorder);
        curr.right = buildTree(mid+1, e, inorder);
        return curr;
    }

    public static TreeNode constructFromInOrder(int[] inOrder) {
        return buildTree(0, inOrder.length-1, inOrder);
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

    public static void solve() {
        int n = scn.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = constructFromInOrder(in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
