// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class PartitionIntoSubsets {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        long[][] dp = new long[k+1][n+1];
        for(int i=0; i<=k; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0 || j<i)
                    dp[i][j] = 0;
                else if(i==j || i==1 )
                    dp[i][j] = 1;
                else{
                    dp[i][j] = dp[i-1][j-1] + i*dp[i][j-1];
                }
                
            }
        }
        System.out.println(dp[k][n]);
    }
}
