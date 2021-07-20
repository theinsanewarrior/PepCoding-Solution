import java.util.*;
public class rootToAllLeafPathMethod2 {
    public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

    public static ArrayList<ArrayList<Integer>> rootToAllLeafPath(TreeNode root) {
        // write your code.
        ArrayList<Integer> asf = new ArrayList();
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        rootToAllLeafPath(asf, ans, root);
        return ans;
    }
    
    public static void rootToAllLeafPath(ArrayList<Integer> asf, ArrayList<ArrayList<Integer>> ans, TreeNode curr){
        if(curr == null)
            return;
        if(curr.left == null && curr.right == null){
            asf.add(curr.val);
            ans.add(new ArrayList(asf));
            asf.remove(asf.size()-1);
            return;
        }
        asf.add(curr.val);
        rootToAllLeafPath(asf, ans, curr.left);
        rootToAllLeafPath(asf, ans, curr.right);
        asf.remove(asf.size()-1);
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
