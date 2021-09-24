import java.util.*;
import java.io.*;
public class maxSumIncreasingSubsequence {
    public static int maxSum(int[] a) {
        // write your code here.
        int[] dp = new int[a.length];
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++){
            int maxSum = 0;
            for(int j=0; j<i; j++){
                if(a[j]<a[i]){
                    maxSum = Math.max(maxSum, dp[j]);
                }
            }
            dp[i] = maxSum+a[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
   }
   
   
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
             arr[i] = sc.nextInt();
        }

        System.out.println(maxSum(arr));
        
   }    
}
