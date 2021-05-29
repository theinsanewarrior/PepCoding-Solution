// package Basics of Programming.Functions and Number System;
import java.util.*;

public class AnyBaseToAnyBase {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int srcBase = scn.nextInt();
        int destBase = scn.nextInt();

        int dec = anyBaseToDecimal(num, srcBase);
        int ans = decimalToAnyBase(dec, destBase);

        System.out.println(ans);

    }

    public static int anyBaseToDecimal(int num, int base){
        int ans = 0;
        int count = 0;
        while(num>0){
            int val = num%10;
            num = num/10;
            ans = ans + val*((int)Math.pow(base, count));
            count++;
        }
        return ans;
    }

    public static int decimalToAnyBase(int num, int base){
        int ans = 0;
        int count=0;
        while(num>0){
            int rem = num%base;
            num = num/base;
            ans = ans + rem*((int)Math.pow(10, count));
            count++;
        }
        return ans;
    }

}
