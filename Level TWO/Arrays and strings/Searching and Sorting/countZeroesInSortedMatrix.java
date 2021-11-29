import javaa.util.*;
public class countZeroesInSortedMatrix {
    public static int countZeros(int[][]arr) {
        //write your code here
        int n = arr.length;
        int ans = 0;
        int i=0, j=n-1;
        while(i<n && j>=0){
            if(arr[i][j] == 0){
                ans+=(j+1);
                i++;
            }else j--;
        }
        return ans;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
    
        int[][]mat = new int[n][n];
    
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            mat[i][j] = scn.nextInt();
          }
        }
    
        System.out.println(countZeros(mat));
    }
}
