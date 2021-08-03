import java.util.*;
public class isGraphBipartite {
    static class Edge {
        int src;
        int nbr;
        int wt;
  
        Edge(int src, int nbr, int wt) {
           this.src = src;
           this.nbr = nbr;
           this.wt = wt;
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
           int wt = Integer.parseInt(parts[2]);
           graph[v1].add(new Edge(v1, v2, wt));
           graph[v2].add(new Edge(v2, v1, wt));
        }
  
        // write your code here
          System.out.println(isBipartite(graph));
     }
      
      public static boolean isBipartite(ArrayList<Edge>[] graph){
          int[] vis = new int[graph.length];
          for(int i=0; i<graph.length; i++){
              if(vis[i] == 0){
                  boolean ans = bipartite(graph, vis, i);
                  if(ans == false)
                      return false;
              }
          }
          return true;
      }
      
      public static class Pair{
          int vtx;
          int state;
          
          Pair(int vtx, int state){
              this.vtx = vtx;
              this.state = state;
          }
      }
      public static boolean bipartite(ArrayList<Edge>[] graph, int[] vis, int src){
          Queue<Pair> q = new ArrayDeque();
          q.add(new Pair(src, 1));
          
          while(q.size() > 0){
              Pair rem = q.remove();
              if(vis[rem.vtx] == 0){
                  vis[rem.vtx] = rem.state;
                  for(Edge curr : graph[rem.vtx]){
                      if(vis[curr.nbr] == 0){
                          int val = (rem.state == 1)? 2: 1;
                          q.add(new Pair(curr.nbr, val));
                      }
                  }
              }
              else{
                  if(vis[rem.vtx] == rem.state)
                      continue;
                  else
                      return false;
              }
          }
          return true;
      }
}
