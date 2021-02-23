// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class CoinChangeCombination {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int amt = scn.nextInt();
        int ans = CoinChangeCombination(arr, amt);
        System.out.println(ans);
    }
    
    public static int CoinChangeCombination(int[] arr, int amt){
        
        int[] dp = new int[amt+1];
        dp[0] = 1;
        for(int i=0; i<arr.length; i++){
            int coin = arr[i];
            for(int j=coin; j<=amt; j++){
                if(dp[j-coin] >0 ){
                    dp[j] += dp[j-coin];
                }
            }
        }
        return dp[amt];
    }
}
