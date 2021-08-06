import java.util.*;
public class kosarajuStronglyConnectedComp {
    public static void main(String args[]) throws Exception {
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
        }
        
        System.out.println(kosaraju(graph));
	}
	
    public static int kosaraju(ArrayList<Integer>[] graph){
        // dfs and get stack
        Stack<Integer> st = new Stack();
        boolean[] vis = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(vis[i] == false)
                dfs(i, graph, vis, st);
        }
        
        // reverse the directions
        ArrayList<Integer>[] revGraph = new ArrayList[graph.length];
        for(int i=0; i<graph.length; i++)
            revGraph[i] = new ArrayList();
        
        for(int i=0; i<graph.length; i++){
            for(int vtx : graph[i]){
                revGraph[vtx].add(i);
            }
        }
        
        // dfs again
        vis = new boolean[graph.length];
        int comp = 0;
        while(st.size()>0){
            int rem = st.pop();
            if(vis[rem] == false){
                dfs(rem, revGraph, vis);
                comp++;
            }
        }
        return comp;
	}
	
	public static void dfs(int idx, ArrayList<Integer>[] graph, boolean[] vis, Stack<Integer> st){
        vis[idx] = true;
        for(int vtx : graph[idx]){
            if(vis[vtx] == false)
                dfs(vtx, graph, vis, st);
        }
        st.push(idx);
	}
	
	public static void dfs(int idx, ArrayList<Integer>[] graph, boolean[] vis){
        vis[idx] = true;
        for(int vtx : graph[idx]){
            if(vis[vtx] == false)
                dfs(vtx, graph, vis);
        }
	}
}
