import java.util.*;
public class longestBitonicSubsequence {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(longestBitonicSubsequence(arr));
        
    }
    
    public static int longestBitonicSubsequence(int[] arr){
        int lis[] = new int[arr.length];
        int lds[] = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            int max = 0;
            for(int j=0; j<i; j++) if(arr[i]>arr[j]) max = Math.max(max, lis[j]);
            lis[i] = max+1;
        }
        for(int i=arr.length-1; i>=0; i--){
            int max = 0;
            for(int j=arr.length-1; j>i; j--) if(arr[i]>arr[j]) max = Math.max(max, lds[j]);
            lds[i] = max+1;
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) ans = Math.max(ans, lis[i]+lds[i]-1);
        return ans;
    }
}
