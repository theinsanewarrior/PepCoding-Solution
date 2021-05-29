package Basics of Programming.Getting Started;

public class PrintAllPrimesTillN {
    public static void main(String[] args) {
        // write your code here
        int min, max;
        Scanner scn = new Scanner(System.in);

        min = scn.nextInt();
        max = scn.nextInt();
        for (int i = min; i <= max; i++) {
            boolean prime = isPrime(i);
            if (prime) {
                System.out.println(i);
            }
        }

    }

    public static boolean isPrime(int n) {
        boolean prime = true;
        for (int j = 2; j <= Math.sqrt(n); j++) {
            if (n % j == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}
