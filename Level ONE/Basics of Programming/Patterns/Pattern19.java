package Basics of Programming.Patterns;

public class Pattern19 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // write ur code here
        
        int stc = n/2;
        int spc = n/2;
        
        // part1
        for(int j=0; j<stc+1; j++){
            System.out.print("*	");
        }
        for(int j=0; j<spc-1; j++){
            System.out.print("	");
        }
        System.out.println("*	");
        
        // part2
        for(int i=1; i<n/2; i++){
            for(int j=0; j<spc; j++){
                System.out.print("	");
            }
            System.out.print("*	");
            for(int j=0; j<spc-1; j++){
                System.out.print("	");
            }
            System.out.println("*	");
        }
        
        // part3
        for(int j=0; j<n; j++){
            System.out.print("*	");
        }
        System.out.println();
        
        // part4
        for(int i=(n/2)+1; i<n-1; i++){
            System.out.print("*	");
            for(int j=0; j<spc-1; j++){
                System.out.print("	");
            }
            System.out.print("*	");
            for(int j=0; j<spc; j++){
                System.out.print("	");
            }
            System.out.println();
        }
        
        // part5
        System.out.print("*	");
        for(int j=0; j<spc-1; j++){
            System.out.print("	");
        }
        for(int j=0; j<stc+1; j++){
            System.out.print("*	");
        }
        System.out.println();
    }
}
