import java.util.*;
public class numberOfIslands2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int m = Integer.parseInt(st[0]);
        int n = Integer.parseInt(st[1]);
        int q = Integer.parseInt(st[2]);
        
        int[][] pos = new int[q][2];
        for (int i = 0; i < q; i++) {
            st = br.readLine().split(" ");
            pos[i][0] = Integer.parseInt(st[0]);
            pos[i][1] = Integer.parseInt(st[1]);
        }
        System.out.println(numIslands2(m, n, pos));
    }
    static int[] parent;
    static int[] rank;
    public static List<Integer> numIslands2(int n, int m, int[][] operators) {
        // write your code here
        int[][] grid = new int[n][m];
        List<Integer> ans = new ArrayList();

        if(operators == null || operators.length==0) return ans;

        int count = 0;
        parent = new int[n*m];
        rank = new int[n*m];

        for(int i=0; i<n*m; i++){
            parent[i] = i;
        }

        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for(int o=0; o<operators.length; o++){
            int i = operators[o][0];
            int j = operators[o][1];
            if(grid[i][j] == 1){
                ans.add(count);
                continue;
            }
            count++;
            grid[i][j] = 1;
            
            int cbno = (i*m)+j;
            for(int r=0; r<dir.length; r++){
                int ni = i+dir[r][0];
                int nj = j+dir[r][1];
                if(ni>=0 && ni<n && nj>=0 && nj<m && grid[ni][nj] == 1){
                    int bno = (ni*m)+nj;
                    boolean val = union(cbno, bno);
                    if(val) count--;
                }
            }
            ans.add(count);
        }
        return ans;
    }
    
    public static boolean union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px!=py){
            if(rank[px] > rank[py]) parent[py] = px;
            else if(rank[px] < rank[py]) parent[px] = py;
            else{
                parent[px] = py;
                rank[py]++;
            }
            return true;
        }
        else return false;
    }

    public static int find(int x){
        if(parent[x] == x)
            return x;
        
        int px = find(parent[x]);
        parent[x] = px;
        return px;
    }
}
