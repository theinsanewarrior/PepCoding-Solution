import java.util.*;
public class HamiltonianPathAndCycle{
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
     
      public static boolean isHamCycle(ArrayList<Edge>[] graph, String asf){
          int val1 = asf.charAt(0) - '0';
          int val2 = asf.charAt(graph.length - 1) - '0';
          
          for(Edge curr : graph[val1]){
              if(curr.nbr == val2)
                  return true;
          }
          return false;
      }
     
      public static void printPaths(ArrayList<Edge>[] graph, int idx, int count, boolean[] visited, String asf){
          if(count==graph.length){
              if(isHamCycle(graph, asf)){
                  asf+="*";
                  System.out.println(asf);
              }
              else{
                  asf+=".";
                  System.out.println(asf);
              }
              return;
          }
          
          visited[idx] = true;
          for(Edge curr : graph[idx]){
              if(visited[curr.nbr] == false)
                  printPaths(graph, curr.nbr, count+1, visited, asf+curr.nbr+"");
          }
          visited[idx] = false;
      }
     
      public static void hamiltonian(ArrayList<Edge>[] graph, int src){
          boolean[] visited = new boolean[graph.length];
          printPaths(graph, src, 1, visited, ""+src);
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
  
        int src = Integer.parseInt(br.readLine());
  
        // write all your codes here
          hamiltonian(graph, src);
     }
}