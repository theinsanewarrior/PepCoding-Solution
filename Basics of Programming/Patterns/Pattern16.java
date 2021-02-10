package Basics of Programming.Patterns;

public class Pattern16 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // write ur code here
        int nc = 1;
        int spc = (2*n) - 3;
        
        for(int i=0; i<n; i++){
            int num = 1;
            for(int j=0; j<nc; j++){
                System.out.print(num+"	");
                num++;
            }
            for(int j=0; j<spc; j++){
                System.out.print("	");
            }
            for(int j=0; j<nc; j++){
                if(i==n-1 && j==0){
                    num-=2;
                    j++;
                }
                else
                    num--;
                System.out.print(num+"	");
            }
            System.out.println();
            
            nc++;
            spc-=2;
            
        }
        

    }
}
