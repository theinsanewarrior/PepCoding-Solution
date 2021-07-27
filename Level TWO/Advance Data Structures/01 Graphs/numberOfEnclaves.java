import java.util.*;
public class numberOfEnclaves {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] st = br.readLine().split(" ");
        int m = Integer.parseInt(st[0]);
        int n = Integer.parseInt(st[1]);
    
        int[][] arr = new int[m][n];
    
        for (int i = 0; i < m; i++) {
          st = br.readLine().split(" ");
          for (int j = 0; j < n; j++) {
            arr[i][j] = Integer.parseInt(st[j]);
          }
        }
    
        System.out.println(numEnclaves(arr));
    
      }
    
      public static int numEnclaves(int[][] grid) {
        for(int i=0; i<grid.length; i++){
                if(grid[i][0] == 1){
                    dfs(grid, i, 0);
                }
                if(grid[i][grid[0].length-1] == 1){
                    dfs(grid, i, grid[0].length-1);
                }
            }
            for(int j=0; j<grid[0].length; j++){
                if(grid[0][j] == 1){
                    dfs(grid, 0, j);
                }
                if(grid[grid.length-1][j] == 1){
                    dfs(grid, grid.length-1, j);
                }
            }
            
            int count = 0;
            for(int i=1; i<grid.length-1; i++){
                for(int j=1; j<grid[0].length-1; j++){
                    if(grid[i][j] == 1){
                        count++;
                        // dfs(grid, i, j);
                    }
                }
            }
            return count;
      }
      
        public static void dfs(int[][] grid, int i, int j){
            if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0)
                return;
            
            grid[i][j] = 0;
            
            dfs(grid, i-1, j);
            dfs(grid, i, j-1);
            dfs(grid, i+1, j);
            dfs(grid, i, j+1);
    
            
        }
}
