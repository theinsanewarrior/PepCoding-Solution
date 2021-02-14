// package Basics of Programming.Arrays;
import java.util.*;
public class InverseOfArray {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val: a) {
            sb.append(val + "
");
        }
        System.out.println(sb);
    }

    public static int[] inverse(int[] a) {
        // write your code here
        
        int[] ans = new int[a.length];
        for(int i=0; i<a.length; i++){
            ans[a[i]] = i;
        }
        
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] inv = inverse(a);
        display(inv);
    }
}
