import java.util.*;
public class verticalOrderTraversalUsingArrayList {
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
        TreeNode node;
        int hl;
        
        Pair(TreeNode node, int hl){
            this.node = node;
            this.hl = hl;
        }
    }
    static int maxhl;
    static int minhl;
    public static void width(TreeNode root, int hl){
        if(hl>maxhl)    
            maxhl = hl;
        if(hl<minhl)
            minhl = hl;
        
        if(root.left!=null)
            width(root.left, hl-1);
        if(root.right!=null)
            width(root.right, hl+1);
    }
    
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        width(root, 0);
        int width = maxhl-minhl+1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        for(int i=0; i<width; i++){
            ans.add(new ArrayList());
        }
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, -minhl));
        while(q.size()>0){
            Pair curr = q.remove();
            ans.get(curr.hl).add(curr.node.val);
            if(curr.node.left!=null)
                q.add(new Pair(curr.node.left, curr.hl-1));
            if(curr.node.right!=null)
                q.add(new Pair(curr.node.right, curr.hl+1));
        }
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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
