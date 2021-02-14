package Basics of Programming.Functions and Number System;

public class AnyBaseMultiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }

    public static int getProduct(int b, int n1, int n2) {
        // write your code here
        int ans = 0, pow=1;;
        while(n2!=0){
            int n = n2%10;
            int val = single_multiply(b, n1, n);
            ans = anybase_add(ans, val*pow, b);
            pow*=10;
            n2= n2/10;
        }
        return ans;
    }
    
    public static int single_multiply(int b, int n1, int n2){
        int val = 0, carry=0, ans = 0, pow=1;
        
        while(n1!=0 || carry!=0){
            int n = n1%10;
            val = (n*n2) + carry;
            carry = val/b;
            ans = ans + (pow*(val%b));
            pow*=10;
            n1 =n1/ 10;
        }
        return ans;
    }
    
    public static int anybase_add(int n1, int n2, int b){
        int carry=0, ans=0, val=0, pow=1;
        
        while(n1!=0 || n2!=0 || carry!=0){
            int rn1 = n1%10;
            int rn2 = n2%10;
            val = rn1+rn2+carry;
            carry = val/b;
            ans = ans+ (pow*(val%b));
            n1=n1/10;
            n2=n2/10;
            pow*=10;
        }
        return ans;
    }
}
