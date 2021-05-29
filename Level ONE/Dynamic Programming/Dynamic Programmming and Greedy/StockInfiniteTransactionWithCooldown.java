import java.util.*;
public class StockInfiniteTransactionWithCooldown {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(stocksWithCooldown(arr));
    }
    
    public static int stocksWithCooldown(int[] arr){
        int bsp = 0-arr[0];
        int ssp = 0;
        int csp = 0;
        
        for(int i=1; i<arr.length; i++){
            int obs = bsp;
            int oss = ssp;
            
            bsp = Math.max(obs, csp-arr[i]);
            ssp = Math.max(oss, obs+arr[i]);
            csp = Math.max(oss, csp);
        }
        return ssp;
    }
}
