package Basics of Programming.Patterns;

public class Pattern10 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int spc1 = n/2;
        int spc2 = -1;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<spc1; j++){
                System.out.print("	");
            }
            System.out.print("*	");
            for(int j=0; j<spc2; j++){
                System.out.print("	");
            }
            if(spc2>0)
                System.out.print("*	");
            System.out.println();
            
            if(i<n/2){
                spc1--;
                spc2+=2;
            }
            else{
                spc1++;
                spc2-=2;
            }
        }

    }
}
