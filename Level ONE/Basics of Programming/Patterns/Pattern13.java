package Basics of Programming.Patterns;

public class Pattern13 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        //write your code here
        int n = scn.nextInt();
        for(int i=0; i<n ;i++){
            int num = 1;
            for(int j=0; j<=i; j++){
                System.out.print(num+"	");
                num = num * (i-j)/(j+1);
                // num *= (i-j)/(j+1); 
            }
            System.out.println();
        }

    }
}
