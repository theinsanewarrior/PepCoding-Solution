// package Basics of Programming.Functions and Number System;
import java.util.*;
public class AnyBaseSubtraction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getDifference(b, n1, n2);
        System.out.println(d);
    }

    public static int getDifference(int b, int n1, int n2) {
        // write your code here
        int val = 0, ans = 0, borrow = 0, pow = 1;

        while (n1 != 0 || n2 != 0 || borrow != 0) {
            int ld1 = n1 % 10, ld2 = n2 % 10;
            val = ld2 + borrow - ld1;
            borrow = 0;
            if (val < 0) {
                borrow = -1;
                val += b;
            }
            ans += val * pow;
            pow *= 10;
            n1 /= 10;
            n2 /= 10;
        }
        return ans;
    }
    
}
