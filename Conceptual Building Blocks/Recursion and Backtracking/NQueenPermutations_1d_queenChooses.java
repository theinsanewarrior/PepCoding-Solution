import java.util.*;
public class NQueenPermutations_1d_queenChooses {
    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // write your code here
        // left
        for(int j=col-1; j>=0; j--){
            if(chess[row][j]!=0)
                return false;
        }
        
        // left diagonal
        for(int i=row-1, j=col-1; i>=0&&j>=0; i--, j--){
            if(chess[i][j]!=0)
                return false;
        }
        
        // top
        for(int i=row-1; i>=0; i--){
            if(chess[i][col]!=0)
                return false;
        }
        
        // right diagonal
        for(int i=row-1, j=col+1; i>=0&&j<chess.length; i--, j++){
            if(chess[i][j]!=0)
                return false;
        }
        
        // right
        for(int j=col+1; j<chess.length; j++){
            if(chess[row][j]!=0)
                return false;
        }
        
        // right bottom diagonal
        for(int i=row+1, j=col+1; i<chess.length&&j<chess.length; i++, j++){
            if(chess[i][j]!=0)
                return false;
        }
        
        // down
        for(int i=row+1; i<chess.length; i++){
            if(chess[i][col]!=0)
                return false;
        }
        
        // left bottom diagonal
        for(int i=row+1, j=col-1; i<chess.length&&j>=0; i++, j--){
            if(chess[i][j]!=0)
                return false;
        }
        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        // write your code here
        if(qpsf == tq){
            for(int i=0; i<tq; i++){
                for(int j=0; j<tq; j++){
                    if(chess[i][j] == 0)
                        System.out.print("-\t");
                    else
                        System.out.print("q" + chess[i][j] + "\t"); 
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int i=0; i<tq; i++){
            for(int j=0; j<tq; j++){
                if(chess[i][j] == 0){
                    if(IsQueenSafe(chess, i, j)){
                        chess[i][j] = qpsf+1;
                        nqueens(qpsf+1, tq, chess);
                        chess[i][j] = 0;
                    }
                }
            }
        }
    }   

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
