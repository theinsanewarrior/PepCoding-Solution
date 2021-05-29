// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class CountEncodings {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int[] dp = new int[str.length()];
        int ans = countEncodings(str, dp);
        System.out.println(ans);
    }
    
    public static int countEncodings(String str, int[] dp){
        
        dp[0] = 1;
        for(int i=1; i<str.length(); i++){
            char ch1 = str.charAt(i-1);
            char ch2 = str.charAt(i);
            if(ch2 - '0' > 0 ){
                dp[i]+=dp[i-1];
            }
            if(ch1 == 0)
                continue;
            int num = (10*(ch1-'0')) + ch2-'0';
            if(num <= 26 && num >= 1){
                if(i==1)
                    dp[i]++;
                else
                    dp[i] += dp[i-2];
            }
            
        }
        return dp[str.length()-1];
        
    }
}
