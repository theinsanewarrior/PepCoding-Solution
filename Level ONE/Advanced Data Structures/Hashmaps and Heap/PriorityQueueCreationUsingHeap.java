import java.util.*;
public class PriorityQueueCreationUsingHeap {
    public static class PriorityQueue {
        ArrayList<Integer> data;
    
        public PriorityQueue() {
          data = new ArrayList<>();
        }
    
        public void add(int val) {
          // write your code here
            data.add(val);
            int idx = data.size()-1;
            upheapify(idx);
        }
        
        private void upheapify(int idx){
            int pidx = (idx-1)/2;
            int val = data.get(idx);
            while(idx!=0 && data.get(pidx) > val){
                data.set(idx, data.get(pidx));
                data.set(pidx, val);
                idx = pidx;
                pidx = (idx-1)/2;
            }
        }
    
        public int remove() {
          // write your code here
          if(data.size()==0){
              System.out.println("Underflow");
              return -1;
          }
          int val = data.get(0);
          data.set(0, data.get(data.size()-1));
          data.remove(data.size()-1);
          downHeapify(0);
          return val;
        }
        
        private void downHeapify(int idx){
            int min = idx;
            int cidx1 = idx*2 + 1;
            int cidx2 = idx*2 + 2;
            
            if(cidx1 < data.size() && data.get(cidx1)<data.get(min) )
                min = cidx1;
            if(cidx2 < data.size() && data.get(cidx2)<data.get(min) )
                min = cidx2;
            
            if(min!=idx){
                int val = data.get(idx);
                data.set(idx, data.get(min) );
                data.set(min, val);
                downHeapify(min);
            }
            
        }
        
        public int peek() {
          // write your code here
          if(data.size()==0){
              System.out.println("Underflow");
              return -1;
          }
          return data.get(0);
        }
    
        public int size() {
          // write your code here
          return data.size();
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();
    
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
