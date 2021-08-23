import java.util.*;
public class medianPriorityQueue {
    public static class MedianPriorityQueue {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
    
        public MedianPriorityQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());//max heap
            right = new PriorityQueue<>();//min heap
        }
    
        public void add(int val) {
            // write your code here
            if(size()==0) left.add(val);
            else if(left.size()>0 && left.peek()>val) left.add(val);
            else right.add(val);
            
            if(left.size() - right.size() > 1) right.add(left.remove());
            else if(right.size() - left.size() > 1 ) left.add(right.remove());
        }
    
        public int remove() {
            // write your code here
            if (size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            
            if (left.size() >= right.size()) return left.remove();
            else return right.remove();
        }
    
        public int peek() {
            // write your code here
            if (size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            
            if (left.size() >= right.size()) return left.peek();
            else return right.peek();
        }
    
        public int size() {
            // write your code here
            return left.size()+right.size();
        }
    }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MedianPriorityQueue qu = new MedianPriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}
