import java.util.*;
public class zeroOneMatrix{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
    
        int[][] arr = new int[n][m];
    
        for (int i = 0; i < n; i++) {
          st = br.readLine().split(" ");
          for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(st[j]);
          }
        }
    
        int[][] ans = updateMatrix(arr);
    
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            System.out.print(ans[i][j] + " ");
          }
          System.out.println();
        }

    }

    public static class Pair{
        int r;
        int c;
        
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new ArrayDeque();
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 0)
                    q.add(new Pair(i, j));
                else
                    mat[i][j] = -mat[i][j];
            }
        }
        
        while(q.size()>0){
            Pair rem = q.remove();
            int i = rem.r, j = rem.c;
            if(i-1>=0 && mat[i-1][j]==-1){
                mat[i-1][j] = mat[i][j]+1;
                q.add(new Pair(i-1, j));
            }
            
            if(j-1>=0 && mat[i][j-1]==-1){
                mat[i][j-1] = mat[i][j]+1;
                q.add(new Pair(i, j-1));
            }
            
            if(i+1<mat.length && mat[i+1][j]==-1){
                mat[i+1][j] = mat[i][j]+1;
                q.add(new Pair(i+1, j));
            }
            
            if(j+1<mat[0].length && mat[i][j+1]==-1){
                mat[i][j+1] = mat[i][j]+1;
                q.add(new Pair(i, j+1));
            }
        }
        return mat;
    }
}