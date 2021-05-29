import java.util.*;
public class Pattern15 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // int n = 5;
        int nc = 1;
        int spc = n/2;
        int num=1;
        for(int i=0; i<n; i++){
            // num=i+1;
            for(int j=0; j<spc; j++){
                System.out.print(" \t");
            }
            for(int j=0; j<nc; j++){
                System.out.print(num+"\t");
                if(j<nc/2){
                    num++;
                }
                else{
                    num--;
                }
            }
            System.out.println();
            if(i<n/2){
                nc+=2;
                spc--;
                num = i+2;
            }
            else{
                nc-=2;
                spc++;
                num = n-i-1;
            }

        }

    }
}