import java.util.*;
public class longestZigZaginBT {
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
        int lp;
        int rp;
        int mp;
        
        Pair(int lp, int rp, int mp){
            this.lp = lp;
            this.rp = rp;
            this.mp = mp;
        }
    }
    
    public static Pair longestZigZagPath1(TreeNode node){
        if(node == null)
            return new Pair(-1 , -1, 0);
        Pair lans = longestZigZagPath1(node.left);
        Pair rans = longestZigZagPath1(node.right);
        return new Pair(lans.rp+1, rans.lp+1, Math.max(Math.max(lans.mp, rans.mp), Math.max(lans.rp+1, rans.lp+1)));
    }
    public static int longestZigZagPath(TreeNode root) {
        Pair ans = longestZigZagPath1(root);
        return ans.mp;
    }

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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
        
        System.out.println(longestZigZagPath(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
