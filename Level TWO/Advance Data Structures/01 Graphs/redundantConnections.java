import java.util.*;
public class redundantConnections {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
    
        int[][] pos = new int[n][2];
        for (int i = 0; i < n; i++) {
          st = br.readLine().split(" ");
          pos[i][0] = Integer.parseInt(st[0]);
          pos[i][1] = Integer.parseInt(st[1]);
        }
    
        int[] ans = findRedundantConnection(pos);
        System.out.println(ans[0] + " " + ans[1]);
    }
    static int[] parent;
    static int[] rank;
    
    public static int[] findRedundantConnection(int[][] edges) {
        int[] ans = new int[2];
        parent = new int[edges.length+1];
        rank = new int[edges.length+1];
        for(int i=1; i<=edges.length; i++){
            parent[i] = i;
        }
        
        for(int i=0; i<edges.length; i++){
            int px = find(edges[i][0]);
            int py = find(edges[i][1]);
            
            if(px==py){
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
                return ans;
            }
            else{
                if(rank[px] > py) parent[py] = px;
                else if(rank[py] > px) parent[px] = py;
                else{
                    parent[px] = py;
                    rank[py]++;
                }
            }
        }
        return ans;
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        
        int px = find(parent[x]);
        parent[x] = px;
        return px;
    }
}
