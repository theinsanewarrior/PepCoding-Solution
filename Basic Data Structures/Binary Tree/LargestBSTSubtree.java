import java.util.*;
public class LargestBSTSubtree {
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
      
        public static class bst{
            int max;
            int min;
            boolean isBST;
            int maxNode;
            int maxSize;
            
            bst(int max, int min, boolean isBST, int maxNode, int maxSize){
                this.max = max;
                this.min = min;
                this.isBST = isBST;
                this.maxNode = maxNode;
                this.maxSize = maxSize;
            }
        }
        
        public static bst largestBstSubtree(Node node){
            if(node == null){
                return new bst(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0, 0);
            }
            bst left = largestBstSubtree(node.left);
            bst right = largestBstSubtree(node.right);
            int max = Math.max(node.data, Math.max(left.max, right.max));
            int min = Math.min(node.data, Math.max(left.min, right.min));
            int maxNode = left.maxNode, maxSize = left.maxSize;
            if(right.maxSize>left.maxSize){
                maxNode = right.maxNode;
                maxSize = right.maxSize;
            }
            if(left.isBST == false || right.isBST == false){
                return new bst(max, min, false, maxNode, maxSize);
            }
            else{
                if(node.data>left.max && node.data<right.min){
                    maxNode = node.data;
                    maxSize = left.maxSize+right.maxSize+1;
                    return new bst(max, min, true, maxNode, maxSize);
                }
                else{
                    return new bst(max, min, true, maxNode, maxSize);
                }
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
            bst ans = largestBstSubtree(root);
            System.out.println(ans.maxNode + "@" + ans.maxSize);
        }
}
