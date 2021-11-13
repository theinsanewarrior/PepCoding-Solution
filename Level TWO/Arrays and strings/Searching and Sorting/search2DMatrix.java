import java.util.*;
import java.io.*;
public class search2DMatrix {
    public static boolean search(int[][]matrix,int target) {
        //write your code here
        int row = searchRow(0, matrix.length-1, matrix, target);
        if(row == -1) return false;
        return searchCol(0, matrix[0].length-1, matrix[row], target);   
    }
    
    public static int searchRow(int l, int h, int[][] matrix, int target){
        if(l>h) return -1;
        int mid = l+(h-l)/2;
        if(matrix[mid][0] <= target && matrix[mid][matrix[0].length-1] >= target){
            return mid;
        }
        else if(matrix[mid][0] > target) return searchRow(l, mid-1, matrix, target);
        else return searchRow(mid+1, h, matrix, target);
    }
    
    public static boolean searchCol(int l, int h, int[] arr, int target){
        if(l>h) return false;
        int mid = l+(h-l)/2;
        if(arr[mid] == target) return true;
        else if(arr[mid] > target) return searchCol(l, mid-1, arr, target);
        else return searchCol(mid+1, h, arr, target);
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
