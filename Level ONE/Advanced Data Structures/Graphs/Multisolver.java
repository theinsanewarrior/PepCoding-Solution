import java.util.*;
public class Multisolver{
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
  
     static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;
  
        Pair(int wsf, String psf){
           this.wsf = wsf;
           this.psf = psf;
        }
  
        public int compareTo(Pair o){
           return this.wsf - o.wsf;
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
  
        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
  
        int criteria = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
  
        boolean[] visited = new boolean[vtces];
        multisolver(graph, src, dest, visited, criteria, k, src + "", 0);
        
        System.out.println("Smallest Path = " + spath + "@" + spathwt);
        System.out.println("Largest Path = " + lpath + "@" + lpathwt);
        System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
        System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
      //   System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
          kthLargest(graph, src, dest, k);
     }
  
  
  
     static String spath;
     static Integer spathwt = Integer.MAX_VALUE;
     static String lpath;
     static Integer lpathwt = Integer.MIN_VALUE;
     static String cpath;
     static Integer cpathwt = Integer.MAX_VALUE;
     static String fpath;
     static Integer fpathwt = Integer.MIN_VALUE;
  //   static PriorityQueue<Pair> pq = new PriorityQueue<>();
     public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
          visited[src] = true;
          if(src == dest){
              // smallest path
              if(spathwt>wsf){
                  spathwt = wsf;
                  spath = psf;
              }
              // largest path
              if(lpathwt<wsf){
                  lpathwt = wsf;
                  lpath = psf;
              }
              // ceil path
              if(wsf>criteria && cpathwt>wsf){
                  cpathwt = wsf;
                  cpath = psf;
              }
              // floor path
              if(wsf<criteria && fpathwt<wsf){
                  fpathwt = wsf;
                  fpath = psf;
              }
              visited[src] = false;
              return;
          }
          
          for(Edge curr : graph[src]){
              int nbr = curr.nbr;
              if(visited[nbr] == false){
                  multisolver(graph, nbr, dest, visited, criteria, k, psf+nbr, wsf+curr.wt);
              }
          }
          visited[src] = false;
     }
     
      public static void kthLargest(ArrayList<Edge>[] graph, int src, int dest, int k){
          int criteria = Integer.MAX_VALUE;
          boolean[] visited = new boolean[graph.length];
          for(int i=0; i<k; i++){
              fpath = "";
              fpathwt = Integer.MIN_VALUE;
              multisolver(graph, src, dest, visited, criteria, k, src+"", 0);
              criteria = fpathwt;
          }
          System.out.println(k + "th largest path = " + fpath + "@" + fpathwt);
      }
}