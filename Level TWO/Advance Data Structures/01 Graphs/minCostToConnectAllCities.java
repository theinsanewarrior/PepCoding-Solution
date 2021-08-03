import java.util.*;
public class minCostToConnectAllCities {
    static class Edge implements Comparable<Edge> {
        int v;
        int wt;
    
        Edge(int nbr, int wt) {
          this.v = nbr;
          this.wt = wt;
        }
    
        @Override
        public int compareTo(Edge o) {
          return this.wt - o.wt;
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vtces; i++) {
          graph.add(new ArrayList<>());
        }
    
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
          String[] parts = br.readLine().split(" ");
          int v1 = Integer.parseInt(parts[0]);
          int v2 = Integer.parseInt(parts[1]);
          int wt = Integer.parseInt(parts[2]);
          graph.get(v1).add(new Edge(v2, wt));
          graph.get(v2).add(new Edge(v1, wt));
        }
        System.out.println(minCostToConnectAllCities(graph));
    
      }
        
        public static int minCostToConnectAllCities(ArrayList<ArrayList<Edge>> graph){
            PriorityQueue<Edge> pq = new PriorityQueue();
            pq.add(new Edge(0, 0));
            int ans = 0;
            boolean[] vis = new boolean[graph.size()];
            while(pq.size()>0){
                Edge rem = pq.remove();
                if(vis[rem.v] == false){
                    vis[rem.v] = true;
                    ans+=rem.wt;
                    for(Edge curr : graph.get(rem.v)){
                        if(vis[curr.v] == false)
                            pq.add(new Edge(curr.v, curr.wt));
                    }
                }
            }
            return ans;
        }
}
