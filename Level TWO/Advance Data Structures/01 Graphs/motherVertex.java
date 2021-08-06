import java.util.*;
public class motherVertex {
    public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);
        
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
        
		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(v);
		}
		System.out.println(findMotherVertex(n, graph));
	}
	
    public static int findMotherVertex(int n, ArrayList<ArrayList<Integer>>graph){
        Stack<Integer> st = new Stack();
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(visited[i] == false)
                dfs(i, graph, st, visited);
        }
        
        // check st.pop() is a mother vertex or not
        visited = new boolean[n];
        int pmv = st.peek();
        int vis = dfs(pmv, graph, visited);
        if(vis == n)
            return pmv+1;
        else
            return -1;
    }
    
    public static void dfs(int idx, ArrayList<ArrayList<Integer>> graph, Stack<Integer> st, boolean[] vis){
        vis[idx] = true;
        for(int i=0; i<graph.get(idx).size(); i++){
            if(vis[graph.get(idx).get(i)] == false){
                dfs(graph.get(idx).get(i), graph, st, vis);
            }
        }
        st.push(idx);
    }
    
    public static int dfs(int idx, ArrayList<ArrayList<Integer>> graph, boolean[] vis){
        vis[idx] = true;
        int count = 0;
        for(int i=0; i<graph.get(idx).size(); i++){
            if(vis[graph.get(idx).get(i)] == false){
                count += dfs(graph.get(idx).get(i), graph, vis);
            }
        }
        return count+1;
    }
}
