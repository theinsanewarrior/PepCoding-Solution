package Basics of Programming.Getting Started;

public class DigitsOfaNumber {
    static public void main(String[] args) {
        // write your code here  
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int n1 = n;
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count++;
        }
        int ten = 1;
        for (int i = 1; i < count; i++) {
            ten *= 10;
        }
        while (count != 0) {
            int val = n1 / ten;
            System.out.println(val);
            n1 = n1 % ten;
            count--;
            ten /= 10;
        }

    }
}
