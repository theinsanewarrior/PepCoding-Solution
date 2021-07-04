import java.util.*;
public class verticalOrderTraversalUsingHashMap {
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

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        int minhl = 0, maxhl = 0;
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        while(q.size()>0){
            Pair curr = q.remove();
            
            if(curr.hl<minhl)
                minhl = curr.hl;
            if(curr.hl>maxhl)
                maxhl = curr.hl;
            
            if(hm.containsKey(curr.hl)){
                hm.get(curr.hl).add(curr.node.val);
            }
            else{
                hm.put(curr.hl, new ArrayList());
                hm.get(curr.hl).add(curr.node.val);
            }
            
            if(curr.node.left!=null)
                q.add(new Pair(curr.node.left, curr.hl-1));
            if(curr.node.right!=null)
                q.add(new Pair(curr.node.right, curr.hl+1));
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=minhl; i<=maxhl; i++){
            ans.add(hm.get(i));
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
