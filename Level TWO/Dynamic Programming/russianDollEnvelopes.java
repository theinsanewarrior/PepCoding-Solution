import java.util.*;
public class russianDollEnvelopes {
    public static class env implements Comparable<env>{
        int wd;
        int ht;
        
        env(int wd, int ht){
            this.wd = wd;
            this.ht = ht;
        }
        
        public int compareTo(env o){
            if(this.wd!=o.wd) return this.wd-o.wd;
            else return this.ht-o.ht;
        }
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        env[] arr = new env[n];
        for(int i=0; i<n; i++) arr[i] = new env(scn.nextInt(), scn.nextInt());
        
        Arrays.sort(arr);
        
        int ans = 0;
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(arr[j].ht<arr[i].ht) max = Math.max(max, dp[j]);
            }
            dp[i] = max+1;
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
