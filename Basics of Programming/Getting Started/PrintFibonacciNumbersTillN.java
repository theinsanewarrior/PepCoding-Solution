package Basics of Programming.Getting Started;

public class PrintFibonacciNumbersTillN {
    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int n1 = 0, n2 = 1;
        if(n>=1)
            System.out.println(n1);
        if(n>=2)
            System.out.println(n2);
        
        for(int i=2; i<n; i++){
            int n3 = n1+n2;
            System.out.println(n3);
            n1 = n2;
            n2 = n3;
        }
    }
}
