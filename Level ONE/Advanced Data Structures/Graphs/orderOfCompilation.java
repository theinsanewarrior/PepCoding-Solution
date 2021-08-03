import java.util.*;
public class orderOfCompilation {
    static class Edge {
        int src;
        int nbr;
  
        Edge(int src, int nbr) {
           this.src = src;
           this.nbr = nbr;
        }
     }
  
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
           graph[i] = new ArrayList<>();
        }
  
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
           String[] parts = br.readLine().split(" ");
           int v1 = Integer.parseInt(parts[0]);
           int v2 = Integer.parseInt(parts[1]);
           graph[v1].add(new Edge(v1, v2));
        }
  
          // write your code here
          boolean[] vis = new boolean[graph.length];
          ans = new Stack();
          for(int i=0; i<graph.length; i++){
              if(vis[i] == false){
                  dfs(graph, i, vis);
              }
          }
          
          while(ans.size()>0)
              System.out.println(ans.pop());
      }
      public static Stack<Integer> ans;
      public static void dfs(ArrayList<Edge>[] graph, int src, boolean[] vis){
          vis[src] = true;
          for(Edge curr : graph[src]){
              if(vis[curr.nbr] == false)
                  dfs(graph, curr.nbr, vis);
          }
          ans.push(src);
      }
}
