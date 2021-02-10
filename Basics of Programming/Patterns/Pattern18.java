package Basics of Programming.Patterns;

public class Pattern18 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        // write ur code here
        
        int spc1 = 1;
        int spc2 = n-4;
        int stc = 1;
        
        for(int i=0; i<n; i++){
            System.out.print("*	");
        }
        System.out.println();
        for(int i=1; i<n; i++){
            for(int j=0; j<spc1; j++){
                System.out.print("	");
            }
            if(i<n/2){
                System.out.print("*	");
                for(int j=0; j<spc2; j++){
                    System.out.print("	");
                }
                System.out.print("*	");
            }
            else{
                for(int j=0; j<stc; j++){
                    System.out.print("*	");
                }
            }
            System.out.println();
            
            if(i<n/2){
                spc1++;
                spc2-=2;
            }
            else{
                spc1--;
                stc+=2;
            }
        }

    }
}
