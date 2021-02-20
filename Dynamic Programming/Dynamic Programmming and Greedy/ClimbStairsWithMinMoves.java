// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;

public class ClimbStairsWithMinJumps {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n+1];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        // int ans = ClimbStairsWithMinMoves(arr, 0);
        // int ans = ClimbStairsWithMinMovesDP(arr, dp, 0);
        int ans = ClimbStairsWithMinMovesTabulation(arr, dp);
        System.out.println(ans);
        
    }
    
    // RECURSION
    
    public static int ClimbStairsWithMinMoves(int[] arr, int curr){
        if(curr == arr.length-1)
            return 0;
        
        int jumps = arr[curr];
        
        int min = Integer.MAX_VALUE - 1;
        for(int i=1; i<=jumps; i++){
            if(curr+i < arr.length){
                int val = ClimbStairsWithMinMoves(arr, curr+i);
                if(min>val)
                    min = val;
            }
        }
        return (min+1);
        
    }
    
    // MEMOIZED
    
    public static int ClimbStairsWithMinMovesDP(int[] arr, int[] dp, int curr){
        if(curr == arr.length-1)
            return 0;
            
        if(dp[curr] != 0){
            return dp[curr];
        }
        
        int jumps = arr[curr];
        
        int min = Integer.MAX_VALUE - 1;
        for(int i=1; i<=jumps; i++){
            if(curr+i < arr.length){
                int val = ClimbStairsWithMinMovesDP(arr,dp, curr+i);
                if(min>val)
                    min = val;
            }
        }
        dp[curr] = min+1;
        return (min+1);
    }
    
    // TABULATION
    
    public static int ClimbStairsWithMinMovesTabulation(int[] arr, int[] dp){
        int n = arr.length;
        
        for(int i=n-1; i>=0; i--){
            int jumps = arr[i];
            int min = Integer.MAX_VALUE-1;
            for(int j=1; j<=jumps; j++){
                if(i+j <= n)
                    if(dp[i+j] < min)
                        min = dp[i+j];
            }
            dp[i] = min+1;
        }
        
        return dp[0];
        
    }
}
