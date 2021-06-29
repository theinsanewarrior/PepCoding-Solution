import java.util.*;
public class constructBTFromInorderAndPredorder {
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
    
    public static TreeNode buildTree(int pst, int pe, int[] preorder, int ist, int ie, int[] inorder){
        if(pst>pe || pst<0)
            return null;
        TreeNode curr = new TreeNode(preorder[pst]);
        int iidx = find(ist, ie, inorder, curr.val);
        int pidx = iidx-ist+pst;
        curr.left = buildTree(pst+1, pidx, preorder, ist, iidx-1, inorder);
        curr.right = buildTree(pidx+1, pe, preorder, iidx+1, ie, inorder);
        return curr;
    }
    
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, preorder.length-1, preorder, 0, inorder.length-1, inorder);
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
        
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();
        
        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
