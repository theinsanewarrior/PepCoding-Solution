import java.util.*;
public class TargetSumPair{
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
      
        public static boolean find(Node node, int num){
            if(node==null)
                return false;
            if(node.data<num)
                return find(node.right, num);
            else if(node.data>num)
                return find(node.left, num);
            else
                return true;
        }
      
        public static void tsp1(Node node, int target, Node root){
            if(node == null)
                return;
            tsp1(node.left, target, root);
            int diff = target-node.data;
            if(diff>node.data)
                if(find(root, diff)){
                    System.out.println(node.data+" "+diff);
                }
            tsp1(node.right, target, root);
        }
        
        static ArrayList<Integer> arr;
        public static void sortedBstArray(Node node){
            if(node == null)
                return;
            sortedBstArray(node.left);
            arr.add(node.data);
            sortedBstArray(node.right);
        }
        
        public static void tsp2(Node node, int target){
            arr = new ArrayList<>();
            sortedBstArray(node);
            int left=0;
            int right=arr.size()-1;
            while(right>left){
                if(arr.get(left) + arr.get(right) == target ){
                    System.out.println(arr.get(left) + " " + arr.get(right) );
                    left++;
                    right--;
                }
                else if(arr.get(left) + arr.get(right) < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        
        public static int incInorder(Stack<Pair> st){
            while(st.size()>0){
                Pair curr = st.peek();
                if(curr.state == 0){
                    if(curr.node.left!=null)
                        st.push(new Pair(curr.node.left, 0));
                    curr.state++;
                }
                else if(curr.state == 1){
                    if(curr.node.right!=null)
                        st.push(new Pair(curr.node.right, 0));
                    curr.state++;
                    return curr.node.data;
                }
                else{
                    st.pop();
                }
            }
            return -1;
        }
        
        public static int decInorder(Stack<Pair> st){
            while(st.size()>0){
                Pair curr = st.peek();
                if(curr.state == 0){
                    if(curr.node.right!=null)
                        st.push(new Pair(curr.node.right, 0));
                    curr.state++;
                }
                else if(curr.state == 1){
                    if(curr.node.left!=null)
                        st.push(new Pair(curr.node.left, 0));
                    curr.state++;
                    return curr.node.data;
                }
                else{
                    st.pop();
                }
            }
            return -1;
        }
        
        public static void tsp3(Node node, int target){
            Stack<Pair>leftSt = new Stack<>();
            Stack<Pair>rightSt = new Stack<>();
            leftSt.push(new Pair(node, 0));
            rightSt.push(new Pair(node, 0));
            int left = incInorder(leftSt);
            int right = decInorder(rightSt);
            while(right>left){
                if(left + right < target)
                    left = incInorder(leftSt);
                else if(left + right > target)
                    right = decInorder(rightSt);
                else{
                    System.out.println(left + " " + right);
                    left = incInorder(leftSt);
                    right = decInorder(rightSt);
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
            
            int data = Integer.parseInt(br.readLine());
            
            Node root = construct(arr);
            // write your code here
            // tsp(root, data, root);
            tsp3(root, data);
        }
}