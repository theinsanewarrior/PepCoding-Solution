import java.util.*;
public class widthOfBinaryTree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    static int minhl;
    static int maxhl;

    public static int width(TreeNode root) {
        minhl = 0;
        maxhl = 0;
        width(root, 0);
        return maxhl-minhl+1;
    }
    
    public static void width(TreeNode root, int h){
        if(h<minhl)
            minhl = h;
        if(h>maxhl)
            maxhl = h;
        
        if(root.left!=null)
            width(root.left, h-1);
        if(root.right!=null)
            width(root.right, h+1);
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

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
