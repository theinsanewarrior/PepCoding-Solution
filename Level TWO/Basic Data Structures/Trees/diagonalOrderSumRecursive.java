import java.util.*;
public class diagonalOrderSumRecursive {
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
    
    public static void diagonalOrderSum(TreeNode node, int level, ArrayList<Integer> ans){
        if(level >= ans.size()){
            ans.add(0);
        }
        ans.set(level, ans.get(level)+node.val);
        if(node.left!=null)
            diagonalOrderSum(node.left, level+1, ans);
        if(node.right!=null)
            diagonalOrderSum(node.right, level, ans);
    }
    
    public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList();
        int level = 0;
        diagonalOrderSum(root, 0, ans);
        return ans;
    }

  // input_section=================================================

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

    ArrayList<Integer> ans = diagonalOrderSum(root);
    for (Integer j : ans)
      System.out.print(j + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}
