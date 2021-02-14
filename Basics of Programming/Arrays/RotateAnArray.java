// package Basics of Programming.Arrays;
import java.util.*;
public class RotateAnArray {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val: a) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void rotate(int[] a, int k) {
        // write your code here
        
        k = k % a.length;
        if(k<0){
            k = k + a.length;
        }
        
        reverse(a, 0, a.length-1);
        reverse(a, 0, k-1);
        reverse(a, k, a.length-1);
        
        return;
    }
    
    public static void reverse(int[] arr, int i, int j){
        
        int lptr = i;
        int rptr = j;
        
        while(lptr<=rptr){
            int temp = arr[lptr];
            arr[lptr] = arr[rptr];
            arr[rptr] = temp;
            
            lptr++;
            rptr--;
        }
        return;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        rotate(a, k);
        display(a);
    }
}
