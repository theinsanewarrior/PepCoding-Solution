import java.util.*;
public class connectPCwithMinWire {
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
          prims(graph);
     }
      
      public static class Dpair implements Comparable<Dpair>{
          int vtx;
          int aq;
          int wt;
          
          Dpair(int vtx, int aq, int wt){
              this.vtx = vtx;
              this.aq = aq;
              this.wt = wt;
          }
          
          public int compareTo(Dpair o){
              return this.wt-o.wt;
          }
      }
      
      public static void prims(ArrayList<Edge>[] graph){
          boolean[] vis = new boolean[graph.length];
          PriorityQueue<Dpair> pq = new PriorityQueue();
          pq.add(new Dpair(0, -1, 0));
          while(pq.size()>0){
              Dpair rem = pq.remove();
              if(vis[rem.vtx] == false){
                  vis[rem.vtx] = true;
                  if(rem.aq != -1)
                      System.out.println("[" + rem.vtx+"-"+rem.aq+"@"+rem.wt + "]");
                  for(Edge curr: graph[rem.vtx]){
                      if(vis[curr.nbr] == false)
                          pq.add(new Dpair(curr.nbr, curr.src, curr.wt));
                  }
              }
          }
      }
}
