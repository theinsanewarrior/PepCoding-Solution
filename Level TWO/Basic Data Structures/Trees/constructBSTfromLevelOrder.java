import java.util.*;
public class constructBSTfromLevelOrder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static class pair{
        TreeNode parent = null;
        int lr = Integer.MIN_VALUE;
        int rr = Integer.MAX_VALUE;
        
        pair(){
            
        }
        
        pair(TreeNode parent, int lr, int rr){
            this.parent = parent;
            this.lr = lr;
            this.rr = rr;
        }
        
    }

    public static TreeNode constructBSTFromLevelOrder(int[] levelOrder) {
        TreeNode root = null;
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair());
        int idx = 0;
        while(q.size()>0 && idx<levelOrder.length){
            pair rem = q.remove();
            
            if(levelOrder[idx] < rem.lr || levelOrder[idx] > rem.rr)
                continue;
            
            TreeNode curr = new TreeNode(levelOrder[idx]);
            idx++;
            if(rem.parent == null)
                root = curr;
            else if(rem.parent.val > curr.val)
                rem.parent.left = curr;
            else
                rem.parent.right = curr;
            
            q.add(new pair(curr, rem.lr, curr.val));
            q.add(new pair(curr, curr.val, rem.rr));
            
        }
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
        int[] level = new int[n];
        for (int i = 0; i < n; i++)
            level[i] = scn.nextInt();

        TreeNode root = constructBSTFromLevelOrder(level);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
