import java.util.*;
public class criticalConnections {
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList();
        }
        for(int i=0; i<connections.size(); i++){
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        
        List<List<Integer>> ans = new ArrayList();
        boolean[] vis = new boolean[n];
        int[] disc = new int[n];
        int[] low = new int[n];
        int[] par = new int[n];
        par[0]=-1;
        time = 0;
        dfs(0, graph, ans, disc, low, par, vis);
        return ans;
    }
    
    public static int time;
    public static void dfs(int idx, ArrayList<Integer>[] graph, List<List<Integer>> ans, int[] disc, int[] low, int[] par, boolean[] vis){
        vis[idx] = true;
        disc[idx] = time;
        low[idx] = time;
        time++;
        
        for(int nbr : graph[idx]){
            if(par[idx] != nbr){
                if(vis[nbr]== true){
                    low[idx] = Math.min(disc[nbr], low[idx]);
                }
                else{
                    par[nbr] = idx;
                    dfs(nbr, graph, ans, disc, low, par, vis);
                    low[idx] = Math.min(low[nbr], low[idx]);
                    
                    if(disc[idx] < low[nbr]){
                        List<Integer> currAns = new ArrayList();
                        currAns.add(idx);
                        currAns.add(nbr);
                        ans.add(currAns);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);
        List<List<Integer>> edges = new ArrayList<>();
        
        for (int i = 0; i < e; i++) {
          edges.add(new ArrayList<>());
          st = br.readLine().split(" ");
          edges.get(i).add(Integer.parseInt(st[0]));
          edges.get(i).add(Integer.parseInt(st[1]));
        }
        
        System.out.println(criticalConnections(n, edges));
        
    }
}
