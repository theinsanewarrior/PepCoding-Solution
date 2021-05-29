// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class StockInfiniteTransaction {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int netProfit = 0;
        int profit = 0;
        int buy = arr[0];
        int sell = arr[0];
        for(int i=0; i<n; i++){
            if(arr[i] < sell){
                netProfit += sell-buy;
                buy = arr[i];
                sell = arr[i];
            }
            else if(arr[i] >= sell ){
                sell = arr[i];
            }
        }
        netProfit+= sell-buy;
        System.out.println(netProfit);
        
    }
}
