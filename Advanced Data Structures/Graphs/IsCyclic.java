import java.util.*;
public class IsCyclic {
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
     
      public static boolean isCompCyclic(ArrayList<Edge>[] graph, int idx, boolean[] visited){
          Queue<Integer>q = new ArrayDeque<>();
          q.add(idx);
          while(q.size()>0){
              int s = q.size();
              for(int i=0; i<s; i++){
                  int curr = q.remove();
                  if(visited[curr] == true){
                      return true;
                  }
                  visited[curr] = true;
                  for(Edge edge: graph[curr]){
                      if(visited[edge.nbr] == false)
                          q.add(edge.nbr);
                  }
              }
          }
          return false;
      }
     
      public static boolean isGraphCyclic(ArrayList<Edge>[] graph){
          boolean visited[] = new boolean[graph.length];
          for(int i=0; i<graph.length; i++){
              if(visited[i] == false){
                  boolean ans = isCompCyclic(graph, i, visited);
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
          System.out.println(isGraphCyclic(graph));
     }
}
