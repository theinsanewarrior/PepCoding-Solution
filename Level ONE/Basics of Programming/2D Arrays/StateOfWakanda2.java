// package Basics of Programming.2D Arrays;
import java.util.*;
public class StateOfWakanda2 {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] mat = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        
        for(int j=0; j<n; j++){
            int c = j, i=0;
            while(c<n){
                System.out.println(mat[i][c]);
                c++;
                i++;
            }
        }
        
    }
}
