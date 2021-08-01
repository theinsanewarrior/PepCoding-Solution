import java.util.*;
public class SpreadOfInfection {
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
           graph[v2].add(new Edge(v2, v1));
        }
  
        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        
        // write your code here
        System.out.println(infectedPeople(graph, src, t));
     }
      
      
      public static int infectedPeople(ArrayList<Edge>[] graph, int src, int time){
          Queue<Integer> q = new ArrayDeque();
          boolean[] vis = new boolean[graph.length];
          int ans = 0;
          q.add(src);
          while(time-->0){
              int size = q.size();
              while(size-->0){
                  int curr = q.remove();
                  if(vis[curr] == false){
                      vis[curr] = true;
                      ans++;
                      for(Edge edge : graph[curr]){
                          if(vis[edge.nbr] == false)
                              q.add(edge.nbr);
                      }
                  }
              }
              
          }
          return ans;
      }
}
