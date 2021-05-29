// package Basics of Programming.Arrays;
import java.util.*;
public class MaximumSubarray {
    public static int maxSum(int[] arr) {
        // write your code here.
        int curr_sum = arr[0];
        int max_sum = arr[0];
        
        for(int i=0; i<arr.length; i++){
            curr_sum = max(curr_sum+arr[i], arr[i] );
            if(curr_sum>max_sum){
                max_sum = curr_sum;
            }
        }
        return max_sum;

    }
    
    public static int max(int a, int b){
        int ans = a;
        if(b>a){
            ans = b;
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
