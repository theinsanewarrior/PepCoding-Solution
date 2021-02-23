// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class ZeroOneKnapsack {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];
        for(int i=0; i<n; i++){
            val[i] = scn.nextInt();
        }
        for(int i=0; i<n; i++){
            wt[i] = scn.nextInt();
        }
        int cap = scn.nextInt();
        int[][] dp = new int[n+1][cap+1];
        int ans = KnapSack(val, wt, dp);
        System.out.println(ans);
    }
    
    public static int KnapSack(int[] val, int[] wt, int[][] dp){
        
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }
        for(int i=1; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(j-wt[i-1] >= 0){
                    dp[i][j] = Math.max((val[i-1]+dp[i-1][j-wt[i-1]]), dp[i-1][j] );
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
}
