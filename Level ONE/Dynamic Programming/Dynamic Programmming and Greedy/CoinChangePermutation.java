// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class CoinChangePermutation {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int amt = scn.nextInt();
        
        int ans = CoinChangePermutation(arr, amt);
        System.out.println(ans);
    }
    
    public static int CoinChangePermutation(int[] arr, int amt){
        int[] dp = new int[amt+1];
        dp[0] = 1;
        for(int i=1; i<=amt; i++){
            for(int j=0; j<arr.length; j++){
                int coin = arr[j];
                if(i-coin>=0 && dp[i-coin]>0 ){
                    dp[i] += dp[i-coin];
                }
            }
        }
        
        return dp[amt];
        
    }
}
