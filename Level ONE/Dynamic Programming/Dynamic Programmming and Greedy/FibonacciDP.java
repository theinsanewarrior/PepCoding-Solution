// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class FibonacciDP {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n+1];
        int fibn = fibMemo(n, arr);
        System.out.println(fibn);
     }
     
     public static int fibMemo(int n, int[] qb){
        if(n==0 || n==1)
            return n;
        
        if(qb[n] != 0)
            return qb[n];
            
        int fibn = fibMemo(n-1, qb) + fibMemo(n-2, qb);
        qb[n] = fibn;
        return fibn;
        
     }
}
