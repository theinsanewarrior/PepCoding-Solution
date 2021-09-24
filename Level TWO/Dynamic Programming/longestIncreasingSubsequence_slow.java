import java.util.*;
public class longestIncreasingSubsequence_slow {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(LIS(arr));
        
    }
    
    public static int LIS(int[] arr){
        int ans = 0;
        int[] dp = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]) max = Math.max(max, dp[j]);
            }
            dp[i] = max+1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
