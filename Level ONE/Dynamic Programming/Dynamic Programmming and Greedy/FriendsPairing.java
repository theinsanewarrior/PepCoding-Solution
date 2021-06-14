// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class FriendsPairing {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }
        System.out.println(dp[n]);
    }
}