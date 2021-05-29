// package Basic Data Structures.Binary Tree;
import java.uti.*;
public class IsBST {
    public static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data, Node left, Node right) {
          this.data = data;
          this.left = left;
          this.right = right;
        }
      }
    
      public static class Pair {
        Node node;
        int state;
    
        Pair(Node node, int state) {
          this.node = node;
          this.state = state;
        }
      }
    
      public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
    
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
    
        int idx = 0;
        while (st.size() > 0) {
          Pair top = st.peek();
          if (top.state == 1) {
            idx++;
            if (arr[idx] != null) {
              top.node.left = new Node(arr[idx], null, null);
              Pair lp = new Pair(top.node.left, 1);
              st.push(lp);
            } else {
              top.node.left = null;
            }
    
            top.state++;
          } else if (top.state == 2) {
            idx++;
            if (arr[idx] != null) {
              top.node.right = new Node(arr[idx], null, null);
              Pair rp = new Pair(top.node.right, 1);
              st.push(rp);
            } else {
              top.node.right = null;
            }
    
            top.state++;
          } else {
            st.pop();
          }
        }
    
        return root;
      }
    
      public static void display(Node node) {
        if (node == null) {
          return;
        }
    
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
    
        display(node.left);
        display(node.right);
      }
    
      public static int height(Node node) {
        if (node == null) {
          return -1;
        }
    
        int lh = height(node.left);
        int rh = height(node.right);
    
        int th = Math.max(lh, rh) + 1;
        return th;
      }
        
        public static class maxmin{
            int min;
            int max;
            boolean bst;
            
            maxmin(int min, int max, boolean bst){
                this.min = min;
                this.max = max;
                this.bst = bst;
            }
        }
        
        public static maxmin isBST(Node node){
            if(node == null){
                return new maxmin(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            }
            maxmin left = isBST(node.left);
            maxmin right = isBST(node.right);
            
            int min = Math.min(node.data, Math.min(left.min, right.min));
            int max = Math.max(node.data, Math.max(left.max, right.max));
            if(left.bst==false || right.bst == false)
                return new maxmin(min, max, false);
            
            if(left.max<node.data && node.data<right.min){
                return new maxmin(min, max, true);
            }
            else{
                return new maxmin(min, max, false);
            }
            
        }
      
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            Integer[] arr = new Integer[n];
            String[] values = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
              if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
              } else {
                arr[i] = null;
              }
            }
        
            Node root = construct(arr);
            
            // write your code here
            System.out.println(isBST(root).bst);
        }
}
