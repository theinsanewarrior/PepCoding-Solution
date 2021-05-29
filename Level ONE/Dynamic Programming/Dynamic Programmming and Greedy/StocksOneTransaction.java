// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class StocksOneTransaction {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int maxProfit = StocksOneTransaction(arr);
        System.out.println(maxProfit);
    }
    
    public static int StocksOneTransaction(int[] arr){
        int min = arr[0];
        int maxProfit = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < min)
                min = arr[i];
            int profit = arr[i] - min;
            if(profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }
}
