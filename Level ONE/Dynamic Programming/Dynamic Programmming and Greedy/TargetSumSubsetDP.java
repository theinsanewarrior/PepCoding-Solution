// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class TargetSumSubsetDP {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        boolean[][] dp = new boolean[n+1][tar+1];
        
        boolean ans = TargetSumSubsets(arr, dp);
        System.out.println(ans);
    }
    
    public static boolean TargetSumSubsets(int[] arr, boolean[][] dp){
        
        for(int i=0; i< dp.length; i++){
            dp[i][0] = true;
        }
        for(int j=1; j<dp[0].length; j++){
            dp[0][j] = false;
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int val = arr[i-1];
                if(j-val >= 0)
                    dp[i][j] = dp[i-1][j-val] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
}
