// package Basics of Programming.Introduction to Recursion;
import java.util.*;
public class Factorial {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        if(n==1)
            return 1;
            
        int ans = n * factorial(n-1);
        return ans;
    }
}
