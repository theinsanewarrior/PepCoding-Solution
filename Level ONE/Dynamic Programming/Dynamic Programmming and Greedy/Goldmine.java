// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class Goldmine {
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
        int max = goldmineTab(mat, dp);
        // int max = 0;
        // for(int i=0; i<row; i++){
        //     int ans = goldmine(mat, i, 0);
        //     if(ans > max)
        //         max = ans;
        // }
        System.out.println(max);
    }
    
    // RECURSION
    
    public static int goldmine(int[][] mat, int r, int c){
        if(c > mat[0].length-1 || r<0 || r > mat.length -1)
            return 0;
        
        // right
        int ans1 = goldmine(mat, r, c+1);
        // up-right
        int ans2 = goldmine(mat, r-1, c+1);
        // down-right
        int ans3 = goldmine(mat, r+1, c+1);
        
        int ans = mat[r][c] + Math.max(ans1,(Math.max(ans2,ans3)));
        return ans;
        
    }

    // TABULATION

    public static int goldmineTab(int[][] mat, int[][] dp){
        for(int j=0; j<dp.length; j++){
            dp[j][dp[0].length-1] = mat[j][dp[0].length-1];
        }
        
        for(int j=mat[0].length-2; j>=0; j--){
            for(int i=0; i<mat.length; i++){
                // up-right
                int upRight = 0;
                if(i!=0)
                    upRight = dp[i-1][j+1];
                
                // down-right
                int downRight = 0;
                if(i!=mat.length-1)
                    downRight = dp[i+1][j+1];
                    
                // right
                int right = dp[i][j+1];
                
                dp[i][j] = mat[i][j] + Math.max(right, (Math.max(upRight, downRight) ));
                
            }
        }
        
        int max = dp[0][0];
        for(int i=1; i<dp.length; i++){
            if(dp[i][0] > max)
                max = dp[i][0];
        }
        
        return max;
        
    }
}
