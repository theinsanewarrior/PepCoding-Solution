// package Basics of Programming.Functions and Number System;
import java.util.*;
public class DecimalToAnyBase {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int base = scn.nextInt();
        
        int num1 = num;
        int ans = 0;
        int count = 0;
        while(num1>0){
            int rem = num1%base;
            num1 = num1/base;
            ans = ans+ rem*((int)Math.pow(10, count));
            count++;
        }
        System.out.println(ans);
    }
}
