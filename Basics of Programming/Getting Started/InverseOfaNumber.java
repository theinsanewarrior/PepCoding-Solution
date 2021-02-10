package Basics of Programming.Getting Started;

public class InverseOfaNumber {
    public static void main(String[] args) {
        // write your code here  
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int index=1;
        int ans=0;
        while(n!=0){
            int val = n%10;
            ans += index*(int)Math.pow(10, val-1);
            n = n/10;
            index++;
        }
        System.out.println(ans);
    }
}
