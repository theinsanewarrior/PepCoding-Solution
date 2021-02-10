package Basics of Programming.Patterns;

public class Pattern5 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        int spc = n / 2;
        int stc = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < spc; j++){
                System.out.print("	");
            }
            for (int j = 0; j < stc; j++) {
                System.out.print("*	");
            }
                if (i < n / 2) {
                    spc--;
                    stc += 2;
                } else {
                    spc++;
                    stc -= 2;
                }
                System.out.println();
            }

    }
}
