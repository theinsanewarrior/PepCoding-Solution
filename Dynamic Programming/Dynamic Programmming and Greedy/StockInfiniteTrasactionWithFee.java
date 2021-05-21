import java.util.*;
public class StockInfiniteTrasactionWithFee {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int fee = scn.nextInt();
        System.out.println(stocksWithFee(arr, fee));
    }
    
    public static int stocksWithFee(int[] arr, int fee){
        int n = arr.length;
        int bsp = 0 - arr[0];
        int ssp = 0;
        for(int i=1; i<n; i++){
            int obs = bsp;
            int oss = ssp;
            bsp = Math.max(obs, oss-arr[i]);
            ssp = Math.max(obs+arr[i]-fee, oss);
        }
        return Math.max(bsp, ssp);
    }
}
