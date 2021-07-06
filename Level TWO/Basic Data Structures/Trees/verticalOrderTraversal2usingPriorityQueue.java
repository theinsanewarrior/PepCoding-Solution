import java.util.*;
public class verticalOrderTraversal2usingPriorityQueue {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static class Pair implements Comparable<Pair>{
        TreeNode node;
        int hl;
        int vl;
        
        Pair(TreeNode node, int hl, int vl){
            this.node = node;
            this.hl = hl;
            this.vl = vl;
        }
        
        public int compareTo(Pair other){
            if(this.vl != other.vl)
                return this.vl-other.vl;
            else if(this.hl != other.hl)
                return this.hl-other.hl;
            else
                return this.node.val-other.node.val;
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
        minhl=0;
        maxhl=0;
        width(root, 0);
        int width = maxhl-minhl+1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        for(int i=0; i<width; i++){
            ans.add(new ArrayList());
        }
        PriorityQueue<Pair> pq = new PriorityQueue();
        pq.add(new Pair(root, -minhl, 0));
        while(pq.size()>0){
            Pair curr = pq.remove();
            ans.get(curr.hl).add(curr.node.val);
            
            if(curr.node.left!=null)
                pq.add(new Pair(curr.node.left, curr.hl-1, curr.vl+1));
            if(curr.node.right!=null)
                pq.add(new Pair(curr.node.right, curr.hl+1, curr.vl+1));
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
