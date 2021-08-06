import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class asFarFromLandAsPossible {

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
        System.out.println(maxDistance(arr));
    }

    static class Pair{
        int i;
        int j;
        
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public static int maxDistance(int[][] grid) {
        Queue<Pair> q = new ArrayDeque();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    q.add(new Pair(i, j));
                }
                else if (grid[i][j] == 0){
                    grid[i][j] = -1;
                }
            }
        }
        
        int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int ans = -1;
        while(q.size()>0){
            Pair rem = q.remove();
            int i = rem.i;
            int j = rem.j;
            for(int r=0; r<4; r++){
                int ni = i+dir[r][0];
                int nj = j+dir[r][1];
                if(ni>=0 && ni<grid.length && nj>=0 && nj<grid[0].length && grid[ni][nj] == -1){
                    grid[ni][nj] = grid[i][j] + 1;
                    if(grid[ni][nj] > ans)
                        ans = grid[ni][nj];
                    q.add(new Pair(ni, nj));
                }
            }
        }
        return ans;
    }
}