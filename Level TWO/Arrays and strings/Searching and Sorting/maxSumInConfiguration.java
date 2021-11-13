import java.util.*;
public class maxSumInConfiguration {
    public static int maximise(int[]arr) {
        //write your code here
        int n = arr.length;
        long sum = 0, psum=0;
        for(long i=0; i<n; i++) {
            sum+=arr[(int)i];
            psum+=(i*arr[(int)i]);
        }
        long maxSum=psum;
        for(long i=n-1; i>=0; i--){
            psum = psum+sum-(long)(n*arr[(int)i]);
            maxSum = Math.max(psum, maxSum);
        }
        return (int)(maxSum%1000000007);
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int ans = maximise(arr);
        System.out.println(ans);
    }
}
