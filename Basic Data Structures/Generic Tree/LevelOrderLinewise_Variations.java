import java.util.*;
public class LevelOrderLinewise_Variations {
    private static class Node{
        int data;
        ArrayList <Node> children = new ArrayList<>();

        Node(int data){
            this.data = data;
        }

        Node(){

        }
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

    public static void levelOrderLinewise1(Node node){
        Queue<Node> order = new ArrayDeque<>();
        order.add(node);
        order.add(new Node(-1));

        while(!order.isEmpty()){
            Node pop = order.remove();
            if(order.size()>0 && pop.data == -1){
                System.out.println();
                order.add(new Node(-1));
            } 
            else{
                for(int i=0; i<pop.children.size(); i++){
                    order.add(pop.children.get(i));
                }
                System.out.print(pop.data + " ");
            }
        }

    }

    public static 

    public static void main(String[] args){
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = construct(arr);
        levelOrderLinewise1(root);
        // display(root);
    }

}
