package Basics of Programming.Getting Started;

public class PrimeFactorizationOfaNumber {
    public static void main(String[] args) {
        // write your code here  
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int n = num;
        int div = 2;
        while (n != 1) {
            if (n % div == 0) {
                n /= div;
                System.out.print(div + " ");
            } else {
                div++;
            }
        }
        System.out.println("");
    }
}
