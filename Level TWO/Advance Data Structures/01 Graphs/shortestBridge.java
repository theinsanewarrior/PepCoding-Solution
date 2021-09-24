import java.util.*;
import java.io.*;
public class shortestBridge {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        
        for (int i = 0; i < n; i++) {
          String[] st = br.readLine().split(" ");
          for (int j = 0; j < n; j++) {
            arr[i][j] = Integer.parseInt(st[j]);
          }
        }
        
        System.out.println(shortestBridge(arr));
    }
    
    public static class pair{
        int i;
        int j;
        pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public static int shortestBridge(int[][] grid) {
        Queue<pair> q = new ArrayDeque();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        boolean flag = false;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(vis[i][j] == false && grid[i][j] == 1){
                    dfs(i, j, grid, q, vis);
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }
        
        
        int level = 0;
        while(q.size() > 0){
            int size = q.size();
            while(size-->0){
                pair rem = q.remove();
                int i=rem.i, j=rem.j;
                //top
                if(i-1>=0 && vis[i-1][j] == false){
                    if(grid[i-1][j] == 1) return level;
                    vis[i-1][j] = true;
                    q.add(new pair(i-1, j));
                }
                //left
                if(j-1>=0 && vis[i][j-1] == false){
                    if(grid[i][j-1] == 1) return level;
                    vis[i][j-1] = true;
                    q.add(new pair(i, j-1));
                }
                //down
                if(i+1<grid.length && vis[i+1][j] == false){
                    if(grid[i+1][j] == 1) return level;
                    vis[i+1][j] = true;
                    q.add(new pair(i+1, j));
                }
                //right
                if(j+1<grid[0].length && vis[i][j+1] == false){
                    if(grid[i][j+1] == 1) return level;
                    vis[i][j+1] = true;
                    q.add(new pair(i, j+1));
                }
            }
            level++;
        }
        return level;
    }
    public static void dfs(int i, int j, int[][] grid, Queue<pair>q, boolean[][] vis){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j]==true || grid[i][j] == 0) return;
        q.add(new pair(i, j));
        vis[i][j]= true;
        dfs(i-1, j, grid, q, vis);
        dfs(i, j-1, grid, q, vis);
        dfs(i+1, j, grid, q, vis);
        dfs(i, j+1, grid, q, vis);
        
    }
}
