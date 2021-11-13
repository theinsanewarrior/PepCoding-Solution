import java.util.*;
import java.io.*;
public class search2DMatrix2 {
    public static boolean search(int[][]matrix,int target) {
        //write your code here
        int i=0, j=matrix[0].length-1;
        while(i<matrix.length && j>=0){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) j--;
            else i++;
        }
        return false;
        
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int[][]matrix = new int[m][n];
        
        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                matrix[i][j] = scn.nextInt();
            }
        }
        int target = scn.nextInt();
        
        boolean isFound = search(matrix,target);
        System.out.println(isFound);

    }
}
