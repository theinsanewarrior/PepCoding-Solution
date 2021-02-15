// package Basics of Programming.2D Arrays;
import java.util.*;
public class RingRotateOfficial {
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
        int shell = scn.nextInt();
        int k = scn.nextInt();
        
        // convert shell to 1d array
        int[] arr = convertTo1dArray(mat, shell);
        
        // rotate array by k
        rotateByK(arr, k);
        
        // convert to shell of matrix
        convertToShell(arr, mat, shell);
        
        display(mat);
        
        
    }
    
    public static int[] convertTo1dArray(int[][] mat, int shell){
        
        
        int rs = shell-1, re = mat.length -shell;
        int cs = shell-1, ce = mat[0].length -shell;
        int n = 2*(ce-cs + re-rs);
        int[] arr = new int[n];
        int p = 0;
        
        for(int i=rs; i<=re; i++ ){
            arr[p] = mat[i][cs];
            p++;
        }
        for(int j=cs+1; j<=ce; j++){
            arr[p] = mat[re][j];
            p++;
        }
        for(int i=re-1; i>=rs; i--){
            arr[p] = mat[i][ce];
            p++;
        }
        for(int j=ce-1; j>=cs+1; j-- ){
            arr[p] = mat[rs][j];
            p++;
        }
        
        return arr;
    }
    
    public static void rotateByK(int[] arr, int k){
        k=k%arr.length;
        if(k<0){
            k = k + arr.length;
        }
        
        reverseArray(arr, 0, arr.length-1);
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, arr.length-1);
        
    }
    
    public static void reverseArray(int[] arr, int left, int right){
        while(left<=right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
    }
    
    public static void convertToShell(int[] arr, int[][] mat, int shell ){
        
        int rs = shell-1, re = mat.length -shell;
        int cs = shell-1, ce = mat[0].length -shell;
        int n = arr.length;
        int p = 0;
        
        for(int i=rs; i<=re; i++ ){
            mat[i][cs] = arr[p];
            p++;
        }
        for(int j=cs+1; j<=ce; j++){
            mat[re][j] = arr[p];
            p++;
        }
        for(int i=re-1; i>=rs; i--){
            mat[i][ce] = arr[p];
            p++;
        }
        for(int j=ce-1; j>=cs+1; j-- ){
            mat[rs][j] = arr[p];
            p++;
        }
        
    }
    

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
