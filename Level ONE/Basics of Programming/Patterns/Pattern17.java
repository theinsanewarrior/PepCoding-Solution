package Basics of Programming.Patterns;

public class Pattern17 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // write ur code here
        
        int spc = n/2, stc = 1;
        
        for(int i=0; i<n; i++){
            if(i==n/2)
                for(int j=0; j<spc; j++){
                    System.out.print("*	");
                }
            else
                for(int j=0; j<spc; j++){
                    System.out.print("	");
                }
                
            for(int j=0; j<stc; j++){
                System.out.print("*	");
            }
            System.out.println();
            
            if(i<n/2)
                stc++;
            else
                stc--;
            
        }

    }
}
