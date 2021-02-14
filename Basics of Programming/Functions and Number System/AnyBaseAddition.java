// package Basics of Programming.Functions and Number System;
import java.util.*;
public class AnyBaseAddition {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int ans = 0;
        int carry = 0;
        int pow=1;
    
        while(carry!=0 || n1!=0 || n2!=0){
            int d1 = n1%10;
            int d2 = n2%10;
            int val = d1 + d2 + carry;
            n1 = n1 / 10;
            n2 = n2 / 10;
            carry = val/b;
            ans = ans + ((val%b)*pow);
            pow*=10;
        }
        
        System.out.println(ans);

    }
}
