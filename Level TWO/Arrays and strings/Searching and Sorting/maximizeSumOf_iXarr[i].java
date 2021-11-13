import java.util.*;
public class maximizeSumOf_iXarr[i] {
    public static int maximise(int[]arr) {
        //write your code here
        Arrays.sort(arr);
        long sum=0;
        for(long i=0; i<arr.length; i++) sum+=(long)(i*arr[(int)i]);
        return (int)(sum%1000000007);
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
