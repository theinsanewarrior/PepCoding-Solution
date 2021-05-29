// package Basic Data Structures.Generic Tree;
import java.util.*;
public class Creation {

    public static class Node{
        int data;
        ArrayList <Node> child = new ArrayList<>();
    }

    public static Node construct(int[] arr){
        Stack<Node> st = new Stack<>();

        Node first = new Node();
        first.data = arr[0];
        Node root = first;
        st.push(first);

        for(int i=1; i<arr.length; i++){
            if(arr[i] == -1){
                st.pop();
                continue;
            }
            Node nayi = new Node();
            nayi.data = arr[i];
            Node old = st.peek();
            old.child.add(nayi);
            st.push(nayi);
        }
        return root;
    }
    
    public static void display(Node root){
        System.out.println(root.data + ", .");
        for(int i=0; i<root.child.size(); i++){
            System.out.print(root.child.get(i).data + ", ");
        }
        System.out.println(".");

        for(int i=0; i<root.child.size(); i++){
            display(root.child.get(i));
        }

    }

    public static void main(String[] args){
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = construct(arr);
        display(root);
    }
}
