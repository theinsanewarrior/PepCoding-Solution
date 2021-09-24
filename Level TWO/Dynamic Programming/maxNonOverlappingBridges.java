import java.util.*;
public class maxNonOverlappingBridges {
    public static class bridge implements Comparable<bridge>{
        int n;
        int s;
        
        bridge(int n, int s){
            this.n = n;
            this.s = s;
        }
        
        public int compareTo(bridge o){
            if(o.n!=this.n) return this.n-o.n;
            else return this.s-o.s;
        }
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        bridge[] arr = new bridge[n];
        for(int i=0; i<n; i++) arr[i] = new bridge(scn.nextInt(), scn.nextInt());
        
        Arrays.sort(arr);
        
        int ans = 0;
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(arr[j].s<arr[i].s) max=Math.max(max, dp[j]);
            }
            dp[i] = max+1;
            ans = Math.max(dp[i], ans);
        }
        System.out.println(ans);
    }
}
