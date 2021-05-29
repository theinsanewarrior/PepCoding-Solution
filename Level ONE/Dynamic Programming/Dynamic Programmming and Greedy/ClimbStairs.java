// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class ClimbStairs {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n+1];
        int ans = ways(n, arr);
        System.out.println(ans);
    }
    
    // memoization
    public static int ways(int n, int[] dp){
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        
        if(dp[n] != 0){
            return dp[n];
        }
        
        int n1 = ways(n-1, dp);
        int n2 = ways(n-2, dp);
        int n3 = ways(n-3, dp);
        int ans = n1 + n2 + n3;
        dp[n] = ans;
        
        return (n1 + n2 + n3);
        
    }
}
