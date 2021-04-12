import java.util.*;
public class Creation {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(){

        }

        Node(int data){
            this.data = data;
        }
    }

    public static class Pair{
        Node node;
        int state;

        Pair(){

        }

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr){
        Stack<Pair> st = new Stack<>();
        Node root = new Node(arr[0]);
        Pair first = new Pair(root, 1);
        st.push(first);
        int i=1;
        while(!st.isEmpty()) {
            Pair top = st.peek();
            if(top.state == 3){
                st.pop();
            }
            else if(top.state == 2 ){
                if(arr[i]!=null){
                    top.node.right = new Node(arr[i]);
                    st.push(new Pair(top.node.right, 1));
                }
                top.state++;
                i++;
            }
            else{
                if(arr[i]!=null){
                    top.node.left = new Node(arr[i]);
                    st.push(new Pair(top.node.left, 1));
                }
                top.state++;
                i++;
            }
        }
        return root;
    }

    public static void display(Node root){
        if(root == null)
            return;
        
        String str = " <- " + root.data + " -> ";
        String left = "";
        String right = "";
        if(root.left != null){
            left = "" + root.left.data;
        }
        if(root.right != null){
            right = "" + root.right.data;
        }
        
        System.out.println(left+str+right);

        display(root.left);
        display(root.right);
    }

    public static void main(String[]args){
        Integer[] arr = {35, 20, 10, 4, null, null, null, 11, 13, null, null, null, 18, 8, 3, null, null, 6, null, null, 9, null, 9, null, null};
        // Integer[]arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};

        Node root = construct(arr);
        display(root);
    }
}