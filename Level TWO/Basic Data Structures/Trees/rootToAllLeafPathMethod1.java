import java.util.*;
public class rootToAllLeafPathMethod1 {
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
//   recursion on the way up
    public static ArrayList<ArrayList<Integer>> rootToAllLeafPath(TreeNode root) {
        // write your code.
        if(root == null)
            return new ArrayList<ArrayList<Integer>>();
        
        if(root.left == null && root.right == null){
            ArrayList<ArrayList<Integer>> base = new ArrayList();
            base.add(new ArrayList());
            base.get(0).add(root.val);
            return base;
        }
        
        ArrayList<ArrayList<Integer>> leftPath = rootToAllLeafPath(root.left);
        ArrayList<ArrayList<Integer>> rightPath = rootToAllLeafPath(root.right);
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        
        for(ArrayList<Integer> curr : leftPath){
            curr.add(0, root.val);
            ans.add(curr);
        }
        for(ArrayList<Integer> curr : rightPath){
            curr.add(0, root.val);
            ans.add(curr);
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

    ArrayList<ArrayList<Integer>> ans = rootToAllLeafPath(root);
    if (ans.size() == 0)
      System.out.println();
    for (ArrayList<Integer> al : ans) {
      for (Integer ele : al)
        System.out.print(ele + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}
