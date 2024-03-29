import java.util.*;
public class preorderMorrisTraversal {
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
    public static TreeNode rightMostNode(TreeNode ln, TreeNode curr){
        TreeNode rmn = ln;
        while(rmn.right!=null && rmn.right!=curr)
            rmn = rmn.right;
        return rmn;
    }
    public static ArrayList<Integer> morrisPreTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode rmn = rightMostNode(curr.left, curr);
                if(rmn.right == null){
                    ans.add(curr.val);
                    rmn.right = curr;
                    curr = curr.left;
                }
                else{
                    rmn.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
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

    ArrayList<Integer> ans = morrisPreTraversal(root);
    for (Integer i : ans)
      System.out.print(i + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}
