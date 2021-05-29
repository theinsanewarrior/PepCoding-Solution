package Basics of Programming.Getting Started;

public class GcdAndLcm {
    // optimised, gcd:euclid approach
    public static int lcm(int num1, int num2, int gcd){
        return num1*num2/gcd;
    }
    
    public static int gcd(int num1, int num2){
        if(num2 == 0)
            return num1;
        return gcd(num2, num1%num2);
    }
    
    public static void main(String[] args) {
      // write your code here  
      Scanner scn = new Scanner(System.in);
      int num1 = scn.nextInt();
      int num2 = scn.nextInt();
      int gcd = gcd(num1, num2);
      int lcm = lcm(num1, num2, gcd);
      System.out.println(gcd + "\n" + lcm);
    }

    // easy approach
    // public static void main(String[] args) {
    //     // write your code here  
    //     Scanner scn = new Scanner(System.in);
    //     int x = scn.nextInt();
    //     int y = scn.nextInt();

    //     if (x < y) {
    //         x = x + y;
    //         y = x - y;
    //         x = x - y;
    //     }

    //     int gcd = 1;
    //     int lcm = x * y;
    //     for (int i = 2; i < y; i++) {
    //         if (x % i == 0 && y % i == 0) {
    //             gcd = i;
    //         }
    //     }

    //     for (int i = 2; i < y; i++) {
    //         int num = x * i;
    //         if (num % y == 0) {
    //             lcm = num;
    //             break;
    //         }
    //     }
    //     System.out.println(gcd + "" + lcm);
    // }
}
