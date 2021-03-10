// package Recursion and Backtracking.RecursionWithBacktracking;
import java.util.*;
public class NQueens {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] chess = new boolean[n][n];
        printNQueens(chess, "", 0);
    }

    public static void printNQueens(boolean[][] chess, String qsf, int row) {
        if(row == chess.length ){
            System.out.println(qsf+".");
            return;
        }
        
        for(int col=0; col< chess[0].length; col++){
            if(!isSafe(chess, row, col) )
                continue;
            chess[row][col] = true;
            printNQueens(chess, qsf+row+"-"+col+", ", row+1);
            chess[row][col] = false;
        }
        
    }
    
    public static boolean isSafe(boolean[][] chess, int row, int col){
        for(int i=row-1; i>=0; i--){
            if(chess[i][col] == true)
                return false;
        }
        
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j-- ){
            if(chess[i][j] == true)
                return false;
        }
        
        for(int i=row-1, j=col+1; i>=0 && j<chess[0].length; i--, j++){
            if(chess[i][j] == true)
                return false;
        }
        
        return true;
        
    }
}
