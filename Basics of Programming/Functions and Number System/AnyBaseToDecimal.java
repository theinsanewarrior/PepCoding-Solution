package Basics of Programming.Functions and Number System;

public class AnyBaseToDecimal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int d = getValueIndecimal(n, b);
        System.out.println(d);
    }

    public static int getValueIndecimal(int n, int b) {
        // write your code here
        int n1 = n;
        int count = 0;
        int ans = 0;
        int pow = 1;
        while (n1 != 0) {
            int rem = n1 % 10;
            ans = ans + (rem * pow);
            pow*=b;
            count++;
            n1 = n1 / 10;
        }
        return ans;
    }
}
