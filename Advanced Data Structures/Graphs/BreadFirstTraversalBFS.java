import java.util.*;
public class BreadFirstTraversalBFS {
    static class Edge {
        int src;
        int nbr;
  
        Edge(int src, int nbr) {
           this.src = src;
           this.nbr = nbr;
        }
     }
      
      static class Pair{
          int val;
          String vsf;
          
          Pair(int val,  String vsf){
              this.val = val;
              this.vsf = vsf;
          }
      }
      
      public static void bfs(ArrayList<Edge>[] graph, int src){
          Queue<Pair>q = new ArrayDeque<>();
          q.add(new Pair(src,""+src));
          boolean[] visited = new boolean[graph.length];
          visited[src] = true;
          while(q.size()>0){
              int s = q.size();
              for(int i=0; i<s; i++){
                  Pair curr = q.remove();
                  // if(visited[curr.val] == true)
                  //     continue;
                  // visited[curr.val] = true;
                  System.out.println(curr.val+"@"+curr.vsf);
                  for(Edge edge:graph[curr.val]){
                      if(visited[edge.nbr]==false){
                          visited[edge.nbr] = true;
                          q.add(new Pair(edge.nbr, curr.vsf+edge.nbr));
                      }
                  }
              }
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
           graph[v2].add(new Edge(v2, v1));
        }
      
          int src = Integer.parseInt(br.readLine());
      
          // write your code here
          bfs(graph, src);
     }
}
