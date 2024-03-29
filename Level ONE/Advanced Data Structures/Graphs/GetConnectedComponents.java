import java.util.*;
public class GetConnectedComponents {
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
      
      static boolean[] visited;
      
      public static ArrayList<Integer> getComponents(ArrayList<Edge>[] graph, int idx){
          visited[idx] = true;
          ArrayList<Integer> ans = new ArrayList<>();
          ans.add(idx);
          for(Edge curr : graph[idx]){
              if(visited[curr.nbr]==false){
                  ArrayList<Integer> list = getComponents(graph, curr.nbr);
                  for(Integer val : list){
                      ans.add(val);
                  }
              }
          }
          return ans;
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
          
          ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
          visited = new boolean[vtces];
          for(int i=0; i<vtces; i++){
              if(visited[i]==false){
                  ArrayList<Integer> val = getComponents(graph, i);
                  comps.add(val);
              }
          }
          System.out.println(comps);
     }
}
