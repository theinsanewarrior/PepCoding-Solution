package Basics of Programming.Getting Started;

public class GcdAndLcm {
    public static void main(String[] args) {
        // write your code here  
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int y = scn.nextInt();

        if (x < y) {
            x = x + y;
            y = x - y;
            x = x - y;
        }

        int gcd = 1;
        int lcm = x * y;
        for (int i = 2; i < y; i++) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
            }
        }

        for (int i = 2; i < y; i++) {
            int num = x * i;
            if (num % y == 0) {
                lcm = num;
                break;
            }
        }
        System.out.println(gcd + "
" + lcm);
    }
}
