import java.util.*;
public class maxPathSumofLeavesInBT {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
            
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static class Pair{
        int ntlp;
        int ltlp;
        
        Pair(int ntlp, int ltlp){
            this.ntlp = ntlp;
            this.ltlp = ltlp;
        }
    }
    
    public static int maxPathSum(TreeNode root) {
        Pair ans = maxSumPath(root);
        return ans.ltlp;
    }
    
    public static Pair maxSumPath(TreeNode root){
        if (root == null) {
            return new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
        } else if (root.left == null && root.right == null) {
            return new Pair(root.val, Integer.MIN_VALUE);
        }
        
        Pair lans = maxSumPath(root.left);
        Pair rans = maxSumPath(root.right);
        
        int factor = Integer.MIN_VALUE;
        if(root.left!=null && root.right!=null)
            factor = lans.ntlp+rans.ntlp+root.val;
        int sntlp = Math.max(lans.ntlp, rans.ntlp) + root.val;
        int sltlp = Math.max(factor , Math.max(lans.ltlp, rans.ltlp) );
        return new Pair(sntlp, sltlp);
    }

  // input_Section=================================================

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
        System.out.println(maxPathSum(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
