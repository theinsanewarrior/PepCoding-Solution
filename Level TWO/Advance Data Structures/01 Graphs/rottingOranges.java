import java.util.*;
public class rottingOranges {
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
    
        System.out.println(orangesRotting(arr));
    
      }
    
        public static class Pair{
            int i;
            int j;
            
            Pair(int i, int j){
                this.i = i;
                this.j = j;
            }
        }
        public static int orangesRotting(int[][] arr) {
            Queue<Pair> q = new ArrayDeque();
            int fresh = 0;
            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr[0].length; j++){
                    if(arr[i][j] == 1)
                        fresh++;
                    else if(arr[i][j] == 2 )
                        q.add(new Pair(i, j));
                }
            }
            
            if(fresh == 0)
                return 0;
            
            int time = -1;
            while(q.size()>0 && fresh>0){
                int size = q.size();
                time++;
                while(size-->0){
                    Pair rem = q.remove();
                    if(arr[rem.i][rem.j] == 1 || time==0){
                        if(arr[rem.i][rem.j] == 1)
                            fresh--;
                        arr[rem.i][rem.j] =2;
                        int i=rem.i, j=rem.j;
                        if(i-1>=0 && arr[i-1][j] == 1)
                            q.add(new Pair(i-1, j));
                        if(j-1>=0 && arr[i][j-1] == 1)
                            q.add(new Pair(i, j-1));
                        if(i+1<arr.length && arr[i+1][j] == 1)
                            q.add(new Pair(i+1, j));
                        if(j+1<arr[0].length && arr[i][j+1] == 1)
                            q.add(new Pair(i, j+1));
                    }
                }
            }
            
            // System.out.println(fresh + " " + time);
            
            if(fresh>0)
                return -1;
            else
                return time;
        }
}
