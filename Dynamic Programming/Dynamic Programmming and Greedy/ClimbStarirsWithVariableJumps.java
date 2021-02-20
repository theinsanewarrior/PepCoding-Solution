import java.util.*;
public class ClimbStarirsWithVariableJumps{
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int[] dp = new int[n+1];
        int ans = climbStairsWithVariableJumps(arr, dp);
        System.out.println(ans);
        
    }
    
    // tabulation
    public static int climbStairsWithVariableJumps(int[] arr, int[] dp){
        int n = arr.length;
        dp[n] = 1;
        
        for(int i=n-1; i>=0; i--){
            int jumps = arr[i];
            for(int j=1; j<=jumps; j++){
                if(i+j <= n)
                    dp[i] = dp[i] + dp[i+j];
            }
        }
        return dp[0];
    }
}