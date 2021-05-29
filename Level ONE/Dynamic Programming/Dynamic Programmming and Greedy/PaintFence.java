// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class PaintFence {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scn= new Scanner(System.in);
        int a=scn.nextInt();
        int b=scn.nextInt();
          System.out.println(CountWays(a,b));
     }
     // -----------------------------------------------------
     // This is a functional problem. Only this function has to be written.
     // This function takes as input 2 integers
     // It should return the required output

     public static int CountWays(int n, int k) {
          //Write your code here
          
          int[][] dp = new int[2][n];
          dp[1][0] = k;
          for(int i=1; i<n; i++){
              dp[0][i] = dp[1][i-1];
              dp[1][i] = (k-1) * (dp[0][i-1]+dp[1][i-1] );
          }
          return dp[0][n-1]+dp[1][n-1];
     }
}
