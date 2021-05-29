// package Basic Data Structures.Stack and Queues;
import java.util.*;
public class StockSpan {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();
    
        for(int val: a){
          sb.append(val + "\n");
        }
        System.out.println(sb);
      }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
    
        int[] span = solve(a);
        display(span);
    }
    
    public static int[] solve(int[] arr){
    // solve
        int n = arr.length;
        int[] ans = new int[n];
        Stack <Integer> stck = new Stack<>();
        stck.push(0);
        ans[0] = 1;
        for(int i=1; i<n; i++){
            while( stck.size() > 0 && arr[stck.peek()] < arr[i] ){
                stck.pop();
            }
            if(stck.size() == 0 )
                ans[i] = i+1;
            else{
                ans[i] = i-stck.peek();
            }
            stck.push(i);
        }
        return ans;
    }
}
