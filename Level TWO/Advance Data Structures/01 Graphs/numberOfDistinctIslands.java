import java.util.*;
public class numberOfDistinctIslands {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
    
        int[][] arr = new int[n][m];
    
        for (int i = 0; i < n; i++) {
          st = br.readLine().split(" ");
          for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(st[j]);
          }
        }
    
        System.out.println(numDistinctIslands(arr));
    
      }
    
      public static StringBuilder psf = new StringBuilder();
    
      public static int numDistinctIslands(int[][] grid) {
            // write your code here
            HashSet<String> set = new HashSet();
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j] == 1){
                        asf = "";
                        dfs(grid, i, j);
                        set.add(asf);
                    }
                }
            }
            // System.out.println(set);
            return set.size();
        }
        public static String asf;
        public static void dfs(int[][] grid, int i, int j){
            
            grid[i][j] = 0;
            
            if(i-1>=0 && grid[i-1][j] == 1){
                asf+="t";
                dfs(grid, i-1, j);
            }
            if(j-1>=0 && grid[i][j-1] == 1){
                asf+="l";
                dfs(grid, i, j-1);
            }
            if(i+1<grid.length && grid[i+1][j] == 1){
                asf+="d";
                dfs(grid, i+1, j);
            }
            if(j+1<grid[0].length && grid[i][j+1] == 1){
                asf+="r";
                dfs(grid, i, j+1);
            }
    
            asf+="z";
    
        }
}
