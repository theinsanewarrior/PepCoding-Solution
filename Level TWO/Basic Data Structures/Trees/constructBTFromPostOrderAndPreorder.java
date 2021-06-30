import java.util.*;
public class constructBTFromPostOrderAndPreorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static TreeNode constructFromPrePost(int prs, int pren, int[] pre, int pos, int poen, int[] post){
        if(prs>pren || pos>poen)
            return null;
        if(prs==pren)
            return new TreeNode(pre[prs]);
        TreeNode curr = new TreeNode(pre[prs]);
        int pridx = pos;
        while(post[pridx] != pre[prs+1]){
            pridx++;
        }
        int poidx = pridx-pos+1;
        
        curr.left = constructFromPrePost(prs+1, prs+poidx, pre, pos, pridx, post);
        curr.right = constructFromPrePost(prs+poidx+1, pren, pre, pridx+1, poen-1, post);
        return curr;
    }
    
    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(0, pre.length-1, pre, 0, post.length-1, post);
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
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = constructFromPrePost(pre, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
