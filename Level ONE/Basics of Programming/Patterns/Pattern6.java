package Basics of Programming.Patterns;

public class Pattern6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // write ur code here
            
        for(int i=0; i<=n/2; i++){
            for(int j=1; j<=n-i-n/2; j++){
                System.out.print("*	");
            }
            for(int j=1; j<=2*i +1; j++){
                System.out.print("	");
            }
            for(int j=1; j<=n-i-n/2; j++){
                System.out.print("*	");
            }
            System.out.println();
            
        }
        
        for(int i=(n/2) +1; i<n; i++ ){
            for(int j=1; j<=i-n/2+1; j++){
                System.out.print("*	");
            }
            for(int j=1; j<= 2*n- 2*i -1; j++){
                System.out.print("	");
            }
            for(int j=1; j<=i-n/2+1; j++){
                System.out.print("*	");
            }
            System.out.println();
        }
    }
}
