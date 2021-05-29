import java.util.*;
public class HasPath {
    static class Edge {
        int src;
        int nbr;
        int wt;
  
        Edge(int src, int nbr, int wt){
           this.src = src;
           this.nbr = nbr;
           this.wt = wt;
        }
     }
     
      public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
          visited[src] = true;
          if(src == dest)
              return true;
          
          for(Edge curr:graph[src]){
              int nbr = curr.nbr;
              if(visited[nbr] == false){
                  boolean ans = hasPath(graph, nbr, dest, visited);
                  if(ans == true)
                      return true;
              }
          }
          return false;
      }
     
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
           graph[i] = new ArrayList<>();
        }
  
        int edges = Integer.parseInt(br.readLine());
        for(int i = 0; i < edges; i++){
           String[] parts = br.readLine().split(" ");
           int v1 = Integer.parseInt(parts[0]);
           int v2 = Integer.parseInt(parts[1]);
           int wt = Integer.parseInt(parts[2]);
           graph[v1].add(new Edge(v1, v2, wt));
           graph[v2].add(new Edge(v2, v1, wt));
        }
  
        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
  
        // write your code here
        boolean[] visited = new boolean[graph.length];
        System.out.println(hasPath(graph, src, dest, visited ));
      }
}
