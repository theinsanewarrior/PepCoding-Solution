package Basics of Programming.Patterns;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i+j<n-1)
                    System.out.print("	");
                else if(i+j>=n-1)
                    System.out.print("*	");
            }
            System.out.println();
        }

    }
}
