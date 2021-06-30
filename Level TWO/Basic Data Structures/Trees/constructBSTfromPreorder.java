import java.util.*;
public class constructBSTfromPreorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode build(int[] pre, int min, int max){
        if(idx>=pre.length)
            return null;
        
        if(pre[idx] >= min && pre[idx] <= max){
            TreeNode curr = new TreeNode(pre[idx]);
            idx++;
            curr.left = build(pre, min, curr.val);
            curr.right = build(pre, curr.val, max);
            return curr;
        }
        else{
            return null;
        }
    }
    
    static int idx;
    
    public static TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
        
        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
