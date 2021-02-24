// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class MaximumSumNonAdjacentElements {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int include = arr[0];
        int exclude = 0;
        for(int i=1; i<n; i++){
            int incTemp = include;
            int excTemp = exclude;
            include = exclude + arr[i];
            exclude = Math.max(incTemp, excTemp);
        }
        
        int ans = Math.max(include, exclude);
        System.out.println(ans);
        
    }
}
