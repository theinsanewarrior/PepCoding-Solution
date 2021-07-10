import java.util.*;
public class camerasInBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    static int cameraCount;
    public static int MinCamerasInBT(TreeNode root) {
        if(root == null)
            return 0;
        cameraCount = 0;
        int val = minCamera(root);
        if(val == 0)
            return cameraCount+1;
        return cameraCount;
    }
    public static int minCamera(TreeNode root){
        int left = 2, right = 2;
        if(root.left!=null)
            left = minCamera(root.left);
        if(root.right!=null)
            right = minCamera(root.right);
        
        if(left == 0 || right == 0){
            cameraCount++;
            return 1;
        }
        else if(left == 1 || right == 1)
            return 2;
        else
            return 0;
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
        System.out.println(MinCamerasInBT(root));

    }

    public static void main(String[] args) {
        solve();
    }
}
