import java.util.*;
public class NodeWithMaxSubtreeSum {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
      }
    
      public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
          str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);
    
        for (Node child : node.children) {
          display(child);
        }
      }
    
      public static Node construct(int[] arr) {
        Node root = null;
    
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
          if (arr[i] == -1) {
            st.pop();
          } else {
            Node t = new Node();
            t.data = arr[i];
    
            if (st.size() > 0) {
              st.peek().children.add(t);
            } else {
              root = t;
            }
    
            st.push(t);
          }
        }
    
        return root;
      }
        
        static int maxSum;
        static int maxNode;
        public static int maxSubtreeSum(Node curr){
            int sum = 0;
            for(int i=0; i<curr.children.size(); i++ ){
                int val = maxSubtreeSum(curr.children.get(i));
                if(val>maxSum){
                    maxSum = val;
                    maxNode = curr.children.get(i).data;
                }
                sum+=val;
            }
            return sum+curr.data;
        }
    
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] values = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
              arr[i] = Integer.parseInt(values[i]);
            }
            Node root = construct(arr);
            // write your code here
            maxSum = Integer.MIN_VALUE;
            int total = maxSubtreeSum(root);
            if(total > maxSum){
                maxSum = total;
                maxNode = root.data;
            }
            System.out.println(maxNode + "@" + maxSum );
        }
}
