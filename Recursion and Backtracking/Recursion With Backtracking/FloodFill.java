// package Recursion and Backtracking.RecursionWithBacktracking;
import java.util.*;
public class FloodFill {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
                visited[i][j] = false;
            }
        }
        floodfill(arr, 0, 0, "", visited);
    }


    public static void floodfill(int[][] maze, int row, int col, String asf, boolean[][] visited) {
        if(row == maze.length-1 && col == maze[0].length-1 ){
            System.out.println(asf);
            return;
        }
        
        visited[row][col] = true;
        
        // top
        if(row-1 >= 0 && maze[row-1][col]==0 && visited[row-1][col] == false )
            floodfill(maze, row-1, col, asf+"t", visited);
            
        //  left
        if(col-1>=0 && maze[row][col-1] == 0 && visited[row][col-1] == false )
            floodfill(maze, row, col-1, asf+"l", visited);
            
        // down
        if(row+1<maze.length && maze[row+1][col] == 0 && visited[row+1][col] == false )
            floodfill(maze, row+1, col, asf+"d", visited);
            
        // right
        if(col+1<maze[0].length && maze[row][col+1] == 0 && visited[row][col+1] == false )
            floodfill(maze, row, col+1, asf+"r", visited);
            
        visited[row][col] = false;
        return;
    }
}
