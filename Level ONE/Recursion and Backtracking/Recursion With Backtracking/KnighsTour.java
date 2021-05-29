// package Recursion and Backtracking.RecursionWithBacktracking;
import java.util.*;
public class KnighsTour {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int row = scn.nextInt();
        int col = scn.nextInt();
        int[][] chess = new int[n][n];
        printKnightsTour(chess, 1, row, col);
    }

    public static void printKnightsTour(int[][] chess, int vsf, int row, int col) {
        if(row<0 || col<0 || row>=chess.length || col>=chess.length || chess[row][col] != 0 ){
            return;
        }
        if(vsf == chess.length*chess.length){
            chess[row][col] = vsf;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }
        
        chess[row][col] = vsf;
        printKnightsTour(chess, vsf+1, row-2, col+1);
        printKnightsTour(chess, vsf+1, row-1, col+2);
        printKnightsTour(chess, vsf+1, row+1, col+2);
        printKnightsTour(chess, vsf+1, row+2, col+1);
        printKnightsTour(chess, vsf+1, row+2, col-1);
        printKnightsTour(chess, vsf+1, row+1, col-2);
        printKnightsTour(chess, vsf+1, row-1, col-2);
        printKnightsTour(chess, vsf+1, row-2, col-1);
        chess[row][col] = 0;
        
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
