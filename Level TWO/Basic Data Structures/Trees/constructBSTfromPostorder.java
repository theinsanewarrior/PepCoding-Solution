import java.util.*;
public class constructBSTfromPostorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static TreeNode buildTree(int[] idx, int min, int max, int[] preorder){
        if(idx[0]<0 || preorder[idx[0]]<min || preorder[idx[0]]>max)
            return null;
        else{
            TreeNode curr = new TreeNode(preorder[idx[0]]);
            idx[0]--;
            curr.right = buildTree(idx, curr.val, max, preorder);
            curr.left = buildTree(idx, min, curr.val, preorder);
            return curr;
        }
    }
    
    public static TreeNode bstFromPostorder(int[] preorder) {
        int[] idx = new int[1];
        idx[0] = preorder.length-1;
        return buildTree(idx, Integer.MIN_VALUE, Integer.MAX_VALUE, preorder);
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
