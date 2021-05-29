// package Basic Data Structures.Generic Tree;
import java.util.*;
public class MultiSolver {
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
    
      public static int size(Node node) {
        int s = 0;
    
        for (Node child : node.children) {
          s += size(child);
        }
        s += 1;
    
        return s;
      }
    
      public static int max(Node node) {
        int m = Integer.MIN_VALUE;
    
        for (Node child : node.children) {
          int cm = max(child);
          m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);
    
        return m;
      }
    
      public static int height(Node node) {
        int h = -1;
    
        for (Node child : node.children) {
          int ch = height(child);
          h = Math.max(h, ch);
        }
        h += 1;
    
        return h;
      }
    
        public static boolean IsSymmetric(Node node) {
            // write your code here
            return areMirror(node, node);
        }
        
        public static boolean areMirror(Node n1, Node n2) {
        // write your code here
            if(n1.children.size()!= n2.children.size() ){
                return false;
            }
            for(int i=0,j=n2.children.size()-1; i<n1.children.size() && j>=0; i++, j-- ){
                boolean recAns = areMirror(n1.children.get(i), n2.children.get(j) );
                if(recAns == false)
                    return false;
            }
            
            return true;
        }

        // MultiSolver solves size, min, max and height in one go
        static int size;
        static int max;
        static int min;
        static int height;

        public static void multiSolver(Node root, int level){
            size++;
            if(root.data > max)
                max = root.data;
            if(root.data < min)
                min = root.data;
            if(level > height)
                height = level;
            for(int i=0; i<root.children.size(); i++ ){
                multiSolver(root.children.get(i), level+1 );
            }
        }

    
      public static void main(String[] args) throws Exception {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        // display(root);

        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height = 0;
        multiSolver(root, 0);
        System.out.println(size);
        System.out.println(max);
        System.out.println(min);
        System.out.println(height);
    }
}
