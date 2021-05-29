package Basics of Programming.Getting Started;

public class IsaNumberPrime {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            boolean prime = true;
            for (int j = 2; j <= Math.sqrt(n); j++) {
                if (n % j == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                System.out.println("prime");
            } else {
                System.out.println("not prime");
            }
        }

    }
}
