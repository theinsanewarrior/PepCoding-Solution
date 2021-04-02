// package Basic Data Structures.Linked Lists;
import java.util.*;
public class ReverseDataRecursive {
    public static class Node {
        int data;
        Node next;
      }
    
      public static class LinkedList {
        Node head;
        Node tail;
        int size;
    
        void addLast(int val) {
          Node temp = new Node();
          temp.data = val;
          temp.next = null;
    
          if (size == 0) {
            head = tail = temp;
          } else {
            tail.next = temp;
            tail = temp;
          }
    
          size++;
        }
    
        public int size() {
          return size;
        }
    
        public void display() {
          for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
          }
          System.out.println();
        }
    
        public void removeFirst() {
          if (size == 0) {
            System.out.println("List is empty");
          } else if (size == 1) {
            head = tail = null;
            size = 0;
          } else {
            head = head.next;
            size--;
          }
        }
    
        public int getFirst() {
          if (size == 0) {
            System.out.println("List is empty");
            return -1;
          } else {
            return head.data;
          }
        }
    
        public int getLast() {
          if (size == 0) {
            System.out.println("List is empty");
            return -1;
          } else {
            return tail.data;
          }
        }
    
        public int getAt(int idx) {
          if (size == 0) {
            System.out.println("List is empty");
            return -1;
          } else if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return -1;
          } else {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
              temp = temp.next;
            }
            return temp.data;
          }
        }
    
        public void addFirst(int val) {
          Node temp = new Node();
          temp.data = val;
          temp.next = head;
          head = temp;
    
          if (size == 0) {
            tail = temp;
          }
    
          size++;
        }
    
        public void addAt(int idx, int val) {
          if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
          } else if (idx == 0) {
            addFirst(val);
          } else if (idx == size) {
            addLast(val);
          } else {
            Node node = new Node();
            node.data = val;
    
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
              temp = temp.next;
            }
            node.next = temp.next;
    
            temp.next = node;
            size++;
          }
        }
    
        public void removeLast() {
          if (size == 0) {
            System.out.println("List is empty");
          } else if (size == 1) {
            head = tail = null;
            size = 0;
          } else {
            Node temp = head;
            for (int i = 0; i < size - 2; i++) {
              temp = temp.next;
            }
    
            tail = temp;
            tail.next = null;
            size--;
          }
        }
    
        public void removeAt(int idx) {
          if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
          } else if (idx == 0) {
            removeFirst();
          } else if (idx == size - 1) {
            removeLast();
          } else {
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
              temp = temp.next;
            }
    
            temp.next = temp.next.next;
            size--;
          }
        }
    
        private Node getNodeAt(int idx) {
          Node temp = head;
          for (int i = 0; i < idx; i++) {
            temp = temp.next;
          }
          return temp;
        }
    
        public void reverseDI() {
          int li = 0;
          int ri = size - 1;
          while (li < ri) {
            Node left = getNodeAt(li);
            Node right = getNodeAt(ri);
    
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
    
            li++;
            ri--;
          }
        }
    
        public void reversePI() {
          if (size <= 1) {
            return;
          }
    
          Node prev = null;
          Node curr = head;
          while (curr != null) {
            Node next = curr.next;
    
            curr.next = prev;
            prev = curr;
            curr = next;
          }
    
          Node temp = head;
          head = tail;
          tail = temp;
        }
    
        public void reversePR() {
          reversePRHelper(head);
          Node temp = head;
          head = tail;
          tail = temp;
          tail.next = null;
        }
        
        public Node reverseDRhelper(Node right, int count){
            if(right == null)
                return head;
            Node left = reverseDRhelper(right.next, count+1);
            if(count<size/2)
                return null;
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
            return left.next;
            
        }
        
        Node left;
        private void revDR(Node right, int count ){
            if(right == null){
                return;
            }
            
            revDR(right.next, count+1);
            
            if(count>= size/2){
                int temp = left.data;
                left.data = right.data;
                right.data = temp;
            }
            left = left.next;
        }
    
        public void reverseDR() {
            // write your code here
            
            // reverseDRhelper(head, 0);
            revDR(head, 0);
            left = head;
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n1 = Integer.parseInt(br.readLine());
        LinkedList l1 = new LinkedList();
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
          int d = Integer.parseInt(values1[i]);
          l1.addLast(d);
        }
    
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
    
        l1.display();
        l1.reverseDR();
        l1.addLast(a);
        l1.addFirst(b);
        l1.display();
      }
}
