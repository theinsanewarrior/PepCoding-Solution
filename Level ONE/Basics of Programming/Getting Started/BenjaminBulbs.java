package Basics of Programming.Getting Started;

public class BenjaminBulbs {
    public static void main(String[] args) {
        // write your code here  
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = 1;
        while (ans * ans < n) {
            System.out.println(ans * ans);
            ans++;
        }
    }
}
