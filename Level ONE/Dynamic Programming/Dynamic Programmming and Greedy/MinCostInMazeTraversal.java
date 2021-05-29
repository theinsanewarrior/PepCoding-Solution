// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class MinCostInMazeTraversal {
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
        int[][] dp = new int[row][col];
        int ans = MinCostMazeTraversal(mat, dp);
        System.out.println(ans);
    }
    
    public static int MinCostMazeTraversal(int[][] mat, int[][] dp){
        
        int row = mat.length-1;
        int col = mat[0].length-1;
        for(int i=row; i>=0; i--){
            for(int j=col; j>=0; j--){
                if(i+1 <= row && j+1 <=col )
                    dp[i][j] = mat[i][j] + Math.min(dp[i+1][j], dp[i][j+1] );
                else if(i+1 <= row)
                    dp[i][j] = mat[i][j] + dp[i+1][j];
                else if(j+1 <= col)
                    dp[i][j] = mat[i][j] + dp[i][j+1];
                else
                    dp[i][j] = mat[i][j];
            }
        }
        
        return dp[0][0];
        
    }
}
