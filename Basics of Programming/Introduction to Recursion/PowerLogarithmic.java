// package Basics of Programming.Introduction to Recursion;
import java.util.*;
public class PowerLogarithmic {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int xToN = power(x, n);
        System.out.println(xToN);
    }

    public static int power(int x, int n){
        if(n==1){
            return x;
        }
        
        int half = n/2;
        int halfPower = power(x, half);
        int ans = halfPower*halfPower;
        if(half*2 == n-1){
            ans = ans*x;
        }
        
        return ans;
    }
}
