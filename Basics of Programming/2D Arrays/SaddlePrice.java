// package Basics of Programming.2D Arrays;
import java.util.*;
public class SaddlePrice {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        int saddle = -1;
        

        for(int i=0; i<n; i++){
            int minIdx = 0;
            for(int j=1; j<n; j++){
                if(mat[i][j] < mat[i][minIdx] )
                    minIdx = j;
            }
            int col;
            for(col = 0; col<n; col++){
                if(mat[col][minIdx] > mat[i][minIdx] ){
                    break;
                }
            }
            if(col == n){
                saddle = mat[i][minIdx];
                break;
            }
            
        }
        
        if(saddle == -1){
            System.out.println("Invalid input");
            return;
        }
        System.out.println(saddle);
        

    }
}
