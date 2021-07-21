import java.util.*;
public class inorderMorrisTraversal {
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

    public static ArrayList<Integer> morrisInTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList();
        TreeNode curr = root;
        while(curr!=null){
            TreeNode leftN = curr.left;
            if(leftN == null){
                ans.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode rmn = rightMostNode(leftN, curr);
                if(rmn.right == curr){
                    rmn.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
                else{
                    rmn.right = curr;
                    curr = curr.left;
                }
            }
        }
        return ans;
    }
    
    public static TreeNode rightMostNode(TreeNode leftN, TreeNode curr){
        TreeNode rmn = leftN;
        while(rmn.right!=null && rmn.right!=curr){
            rmn = rmn.right;
        }
        return rmn;
    }

  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);

    ArrayList<Integer> ans = morrisInTraversal(root);
    for (Integer i : ans)
      System.out.print(i + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}
