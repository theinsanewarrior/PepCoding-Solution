import java.util.*;
public class articulationPoint {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int m = Integer.parseInt(inp[1]);
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList();
        }
        for(int i=0; i<m; i++){
            inp = br.readLine().split(" ");
            int a = Integer.parseInt(inp[0])-1;
            int b = Integer.parseInt(inp[1])-1;
            graph[a].add(b);
            graph[b].add(a);
        }
        
        System.out.println(articulationPoints(graph));
    }
    
    static int[] disc;
    static int[] low;
    static int[] par;
    static boolean[] ap;
    static boolean[] vis;
    static int time;
    static int srcCount;
    
    public static int articulationPoints(ArrayList<Integer>[] graph){
        int n = graph.length;
        disc = new int[n];
        low = new int[n];
        par = new int[n];
        ap = new boolean[n];
        vis = new boolean[n];
        srcCount = 0;
        time = 0;
        
        par[0] = -1;
        dfs(0, graph);
        
        int count = 0;
        for(int i=0; i<n; i++){
            if(ap[i] == true) count++;
        }
        return count;
    }
    
    public static void dfs(int idx, ArrayList<Integer>[] graph){
        vis[idx] = true;
        disc[idx] = time;
        low[idx] = time;
        time++;
        
        for(int vtx : graph[idx]){
            if(vtx == par[idx])
                continue;
            else if(vis[vtx] == true){
                low[idx] = Math.min(low[idx], disc[vtx]);
            }
            else if(vis[vtx] == false){
                par[vtx] = idx;
                dfs(vtx, graph);
                low[idx] = Math.min(low[idx], low[vtx]);
                
                if(par[idx] == -1){
                    srcCount++;
                    if(srcCount > 1)
                        ap[0] = true;
                }
                else if(disc[idx] <= low[vtx])
                    ap[idx] = true;

                // articulation bridge
                if (disc[idx] < low[vtx]) {
                    System.out.println(idx + "---" + vtx);
                }
            }
        }
    }
}
