import java.util.*;
public class maxPathSumofNodesInBTMethodPair {
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
        int rtnp;
        int ntnp;
        
        Pair(int rtnp, int ntnp){
            this.rtnp = rtnp;
            this.ntnp = ntnp;
        }
    }

    public static int maxPathSum(TreeNode root) {
        Pair ans = maxSumPath(root);
        return ans.ntnp;
    }
    
    public static Pair maxSumPath(TreeNode root){
        if(root == null)
            return new Pair(0, Integer.MIN_VALUE);
        Pair lans = maxSumPath(root.left);
        Pair rans = maxSumPath(root.right);
        
        int f1 = root.val + lans.rtnp;
        int f2 = root.val + rans.rtnp;
        int f3 = lans.rtnp + root.val + rans.rtnp;
        int f4 = root.val;
        
        return new Pair(max(f1, f2, f4) , max(f1, f2, f3, f4, lans.ntnp, rans.ntnp));
    }
    
    public static int max(int ...arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
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
