// package Basics of Programming.2D Arrays;
import java.util.*;
public class RotateBy90Degree {
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
        
        // take transpose
        transpose(mat);
        
        // column reversal
        columnReverse(mat);
        
        display(mat);
        
    }
    
    public static void transpose(int mat[][]){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<=i; j++){
                swap(mat, i, j, j, i);
            }
        }
    }
    
    public static void swap(int mat[][],int r1,int c1,int r2,int c2){
        int temp = mat[r1][c1];
        mat[r1][c1] = mat[r2][c2];
        mat[r2][c2] = temp;
    }
    
    public static void columnReverse(int mat[][]){
        
        for(int i=0; i<mat.length; i++){
            int lptr = 0;
            int rptr = (mat[0].length) - 1;
            while(lptr<=rptr){
                swap(mat, i ,lptr ,i ,rptr );
                lptr++;
                rptr--;
            }
        }
        
    }
    
    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
