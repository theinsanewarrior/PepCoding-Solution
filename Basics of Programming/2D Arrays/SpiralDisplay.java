// package Basics of Programming.2D Arrays;
import java.util.*;

public class SpiralDisplay {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();
        int[][] arr = new int[row][col];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        int count = row*col ;
        
        int rs = 0, re = row-1;
        int cs = 0, ce = col-1;
        
        while(count > 0){
            
            if(count>0)
            for(int i=rs; i<=re; i++){
                System.out.println(arr[i][cs]);
                count--;
            }
            cs+=1;
            if(count>0)
            for(int j=cs; j<=ce; j++){
                System.out.println(arr[re][j]);
                count--;
            }
            re-=1;
            if(count>0)
            for(int i=re; i>=rs; i--){
                System.out.println(arr[i][ce] );
                count--;
            }
            ce-=1;
            if(count>0)
            for(int j=ce; j>=cs; j--){
                System.out.println(arr[rs][j] );
                count--;
            }
            rs+=1;

        }
        
        
    }
}
