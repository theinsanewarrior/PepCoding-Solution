import java.util.*;
public class NQueensBranchAndBound {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        //write your code here
        boolean[] col = new boolean[n];
        boolean[] leftD = new boolean[(2*n)-1];
        boolean[] rightD = new boolean[(2*n)-1];
        nqueens(n, 0, "", col, leftD, rightD);
      }
      
      public static boolean isQueenSafe(int r, int c, boolean[]col, boolean[] leftD, boolean[] rightD){
            if(col[c] == true)
                return false;
            
            if(leftD[r+c] == true)
                return false;
            
            if(rightD[r-c + col.length-1] == true)
                return false;
            
            return true;
      }
      
      public static void nqueens(int n, int row, String asf, boolean[] col, boolean[] leftD, boolean[] rightD){
          if(row == n){
              System.out.println(asf+".");
              return;
          }
          
          for(int j=0; j<n; j++){
              if(isQueenSafe(row, j, col, leftD, rightD)==true){
                  col[j] = true;
                  leftD[row+j] = true;
                  rightD[row-j + n-1] = true;
                  
                  nqueens(n, row+1, asf+row+"-"+j+", ", col, leftD, rightD);
                  
                  col[j] = false;
                  leftD[row+j] = false;
                  rightD[row-j + n-1] = false;
              }
          }
      }
}
