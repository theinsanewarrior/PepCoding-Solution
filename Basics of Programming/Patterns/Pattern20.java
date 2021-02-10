package Basics of Programming.Patterns;

public class Pattern20 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // write ur code here
        if(n==1){
            System.out.println("*	");
            return ;
        }
        
        int spc1 = ((n-3)/2)-1;
        int spc2 = 1;
        
        // part 1
        for(int i=0; i<n/2; i++){
            System.out.print("*	");
            for(int j=0; j<n-2; j++){
                System.out.print("	");
            }
            System.out.println("*	");
            
        }
        
        // part2
        System.out.print("*	");
        for(int j=0; j<(n-3)/2; j++){
            System.out.print("	");
        }
        System.out.print("*	");
        for(int j=0; j<(n-3)/2; j++){
            System.out.print("	");
        }
        System.out.println("*	");
        
        // part3
        
        for(int i=(n/2)+1; i<n-1; i++){
            System.out.print("*	");
            for(int j=0; j<spc1; j++){
                System.out.print("	");
            }
            System.out.print("*	");
            for(int j=0; j<spc2; j++){
                System.out.print("	");
            }
            System.out.print("*	");
            for(int j=0; j<spc1; j++){
                System.out.print("	");
            }
            System.out.println("*	");
            spc1--;
            spc2+=2;
        }
        
        // part4
        
        System.out.print("*	");
        for(int j=0; j<n-2; j++){
            System.out.print("	");
        }
        System.out.println("*	");
        

    }
}
