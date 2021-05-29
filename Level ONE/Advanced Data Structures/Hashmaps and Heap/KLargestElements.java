import java.util.*;
public class KLargestElements {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
  
        for (int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }
  
        int k = Integer.parseInt(br.readLine());
          // write your code here
          PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
          for(int i=0; i<n; i++){
              if(pq.size()<k){
                  pq.add(arr[i]);
              }
              else{
                  if(pq.peek()<arr[i]){
                      pq.remove();
                      pq.add(arr[i]);
                  }
              }
          }
          
          for(int i=0; i<k; i++){
              System.out.println(pq.remove());
          }
          
      }
}
