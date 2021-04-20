public class constructFromSortedArray {
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

    public static Node construct(int[] arr, int left, int right){
        if(left>right){
            return null;
        }
        int mid = (left+right)/2;
        Node node = new Node(arr[mid]);

        node.left = construct(arr, left, mid-1);
        node.right = construct(arr, mid+1, right);
        return node;
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

    public static void main(String[] args){
        int[] arr = {12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87};
        Node root = construct(arr, 0, arr.length-1);
        display(root);
    }
}
