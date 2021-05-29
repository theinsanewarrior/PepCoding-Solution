import java.util.*;
public class ConstructWithArray {
    public static class Edge{
        int src;
        int nbr;
        int wt;
        
        Edge(){}

        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int val1, int val2, int wt ){
        graph[val1].add(new Edge(val1, val2, wt));
        graph[val2].add(new Edge(val2, val1, wt));
    }

    public static void display(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            System.out.print(i+ " -> ");
            for(int j=0; j<graph[i].size(); j++){
                Edge curr = graph[i].get(j);
                System.out.print(curr.src + " - " + curr.nbr + " @ " + curr.wt + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        }

        addEdge(graph,0,1,10);
        addEdge(graph,0,3,40);
        addEdge(graph,1,2,10);
        addEdge(graph,2,3,10);
        addEdge(graph,3,4,2);
        addEdge(graph,4,5,6);
        addEdge(graph,4,6,3);
        addEdge(graph,5,6,3);

        display(graph);
        
    }

}
