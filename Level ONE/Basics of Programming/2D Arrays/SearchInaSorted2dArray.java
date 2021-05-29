// package Basics of Programming.2D Arrays;
import java.util.*;
public class SearchInaSorted2dArray {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        int key = scn.nextInt();

        int i = 0, j = n - 1;
        while (i >= 0 && j >= 0 && i<n && j<n){
            if(mat[i][j] == key)
                break;
            else if(mat[i][j] > key)
                j--;
            else
                i++;
        }
        
        if(i<0 || j<0 || i==n || j ==n)
            System.out.println("Not Found");
        else
            System.out.println(i + " " + j);

    }
}
