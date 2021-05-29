// package Basics of Programming.2D Arrays;
import java.util.*;
public class Wakanda1Official {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();
        int[][] mat = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        
        for(int j=0; j<col; j++){
            if(j%2==0){
                for(int i=0; i<row; i++){
                    System.out.println(mat[i][j] );
                }
            }
            else{
                for(int i=row-1; i>=0; i--){
                    System.out.println(mat[i][j] );
                }
            }
        }
        
        
    }
}
