package Basics of Programming.Getting Started;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        // write your code here  
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();

        if (a < b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        if (a < c) {
            a = a + c;
            c = a - c;
            a = a - c;
        }

        if (a * a == (b * b) + (c * c)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
