import java.util.*;
public class numberOfIslands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];
        
        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }
        
        // write your code here
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 0){
                    count++;
                    dfs(i, j, arr);
                }
            }
        }
        System.out.println(count);
    }
   
    public static void dfs(int i, int j, int[][] arr){
        if(i<0 || j<0 || i>=arr.length|| j>=arr[0].length || arr[i][j] == 1)
            return;
        
        arr[i][j] = 1;
        
        dfs(i-1, j, arr);
        dfs(i, j-1, arr);
        dfs(i+1, j, arr);
        dfs(i, j+1, arr);
        
    }
}
