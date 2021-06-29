import java.util.*;
public class constructBTFromInorderAndPostorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static int find(int st, int e, int[] arr, int num){
        for(int i=st; i<=e; i++){
            if(arr[i] == num)
                return i;
        }
        return -1;
    }
    
    public static TreeNode buildTree(int ist, int ie, int[] inorder, int pst, int pe, int[] postorder){
        if(ist>ie)
            return null;
        TreeNode curr = new TreeNode(postorder[pe]);
        int iidx = find(ist, ie, inorder, postorder[pe]);
        int pidx = iidx - ist + pst;
        curr.left = buildTree(ist, iidx-1, inorder, pst, pidx-1, postorder);
        curr.right = buildTree(iidx+1, ie, inorder, pidx, pe-1, postorder);
        return curr;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(0, inorder.length-1, inorder, 0, postorder.length-1, postorder);
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

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
