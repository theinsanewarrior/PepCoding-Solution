import java.util.*;
public class validateBSTusingMorrisTraversal {
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

    public static boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        boolean ans = true;
        TreeNode prev = null;
        while(curr!=null){
            if(curr.left == null){
                if(prev!=null && prev.val >= curr.val){
                    ans = false;
                    break;
                }
                prev = curr;
                curr = curr.right;
            }
            else{
                TreeNode rmn = rightMostNode(curr.left, curr);
                if(rmn.right == null){
                    rmn.right = curr;
                    curr = curr.left;
                }
                else{
                    rmn.right = null;
                    if(prev!=null && prev.val >= curr.val){
                        ans = false;
                        break;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

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
        System.out.println(isValidBST(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
