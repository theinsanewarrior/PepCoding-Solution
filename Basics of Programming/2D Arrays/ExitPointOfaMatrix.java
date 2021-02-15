// package Basics of Programming.2D Arrays;
import java.util.*;
public class ExitPointOfaMatrix {
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
        
        int dir = 0, i=0, j=0, r=0, c=0;
        
        while(i>=0 && j>=0 && i<row && j<col){
            r=i;
            c=j;
            dir = (dir + mat[i][j]) % 4;
            
            if(dir == 0)
                j++;
            else if(dir == 1)
                i++;
            else if(dir == 2)
                j--;
            else
                i--;
        }
        
        System.out.println(r+ "
"+ c);
        
    }
}
