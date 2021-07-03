import java.util.*;
public class constructBTfromInorderAndLevelorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(int inord[], int level[])
    {
        //your code here
        HashMap<Integer, Integer> find = new HashMap<>();
        for(int i=0; i<inord.length; i++){
            find.put(inord[i], i);
        }
        return buildTree(0, inord.length-1, inord, find, level);
    }
    
    public static TreeNode buildTree(int ist, int ie, int[] inorder, HashMap<Integer, Integer> find, int[] levelorder){
        if(ie<ist)
            return null;
        TreeNode root = new Node(levelorder[0]);
        int idx = find.get(root.data);
        int[] left = new int[idx-ist];
        int[] right = new int[ie-idx];
        int li = 0, ri = 0;
        for(int i=1; i<levelorder.length; i++){
            int tidx = find.get(levelorder[i]);
            if(tidx<idx){
                left[li] = levelorder[i];
                li++;
            }
            else{
                right[ri] = levelorder[i];
                ri++;
            }
        }
        root.left = buildTree(ist, idx-1, inorder, find, left);
        root.right = buildTree(idx+1, ie, inorder, find, right);
        return root;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = buildTree(pre, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
